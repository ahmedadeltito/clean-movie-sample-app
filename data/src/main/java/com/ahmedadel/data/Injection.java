package com.ahmedadel.data;

import android.content.Context;

import com.ahmedadel.data.local.DatabaseManager;
import com.ahmedadel.data.local.dao.MovieDao;
import com.ahmedadel.data.local.dao.PersonDao;
import com.ahmedadel.data.local.dao.TVDao;
import com.ahmedadel.data.remote.APIClient;
import com.ahmedadel.data.remote.client.MovieAppAPI;
import com.ahmedadel.data.repository.MovieRepositoryImpl;
import com.ahmedadel.data.repository.PersonRepositoryImpl;
import com.ahmedadel.data.repository.TVRepositoryImpl;
import com.ahmedadel.domain.repository.MovieRepository;
import com.ahmedadel.domain.repository.PersonRepository;
import com.ahmedadel.domain.repository.TVRepository;

public class Injection {

    private static MovieDao getMovieDao(Context context) {
        return DatabaseManager.getInstance(context).movieDao();
    }

    private static PersonDao getPersonDao(Context context) {
        return DatabaseManager.getInstance(context).personDao();
    }

    private static TVDao getTVDao(Context context) {
        return DatabaseManager.getInstance(context).tvDao();
    }

    private static MovieAppAPI getMovieAppAPI() {
        return APIClient.getMovieAppAPI();
    }

    public static MovieRepository getMovieRepository(Context context) {
        return new MovieRepositoryImpl(getMovieDao(context), getMovieAppAPI());
    }

    public static PersonRepository getPersonRepository(Context context) {
        return new PersonRepositoryImpl(getPersonDao(context), getMovieAppAPI());
    }

    public static TVRepository getTVRepository(Context context) {
        return new TVRepositoryImpl(getTVDao(context), getMovieAppAPI());
    }
}
