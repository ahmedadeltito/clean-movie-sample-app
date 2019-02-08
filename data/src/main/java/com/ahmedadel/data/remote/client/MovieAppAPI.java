package com.ahmedadel.data.remote.client;

import com.ahmedadel.data.remote.model.MovieListRemote;
import com.ahmedadel.data.remote.model.MovieRemote;
import com.ahmedadel.data.remote.model.PersonListRemote;
import com.ahmedadel.data.remote.model.PersonRemote;
import com.ahmedadel.data.remote.model.TVListRemote;
import com.ahmedadel.data.remote.model.TVRemote;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAppAPI {

    // Movie APIs
    @GET("/3/movie/popular")
    Single<MovieListRemote> getMovies(@Query("page") Integer pageNumber);

    @GET("/3/movie/{id}")
    Single<MovieRemote> getMovie(@Path("id") Integer movieId);
    // ---------------------------------------------------------------------------------------- //

    // TV APIs
    @GET("/3/tv/popular")
    Single<TVListRemote> getTVs(@Query("page") Integer pageNumber);

    @GET("/3/tv/{id}")
    Single<TVRemote> getTV(@Path("id") Integer tvId);
    // ---------------------------------------------------------------------------------------- //

    // Person APIs
    @GET("/3/person/popular")
    Single<PersonListRemote> getPersons(@Query("page") Integer pageNumber);

    @GET("/3/person/{id}")
    Single<PersonRemote> getPerson(@Path("id") Integer personId);
    // ---------------------------------------------------------------------------------------- //

}
