package com.ahmedadel.data.remote;

import com.ahmedadel.data.remote.client.APIKeyInterceptor;
import com.ahmedadel.data.remote.client.MovieAppAPI;
import com.ahmedadel.data.remote.client.SettingsAPI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static APIClient apiClient;
    private SettingsAPI settings;

    public static APIClient getInstance(SettingsAPI settings) {
        if (apiClient == null)
            apiClient = new APIClient(settings);
        return apiClient;
    }

    private APIClient(SettingsAPI settings) {
        this.settings = settings;
    }

    private OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(settings.getTimeout(), TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(settings.getTimeout(), TimeUnit.MILLISECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(getApiKeyInterceptor(settings));

        return httpClient.build();
    }

    private APIKeyInterceptor getApiKeyInterceptor(SettingsAPI settings) {
        return new APIKeyInterceptor(settings);
    }

    public static MovieAppAPI getMovieAppAPI() {
        if (apiClient == null)
            throw new IllegalArgumentException("APIClient is null, " +
                    "you should call getMovieAppAPI() after calling getInstance()");
        return new Retrofit.Builder()
                .baseUrl(apiClient.settings.getBaseURL())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(apiClient.getHttpClient())
                .build()
                .create(MovieAppAPI.class);
    }

}
