package com.ahmedadel.domain.repository;

import com.ahmedadel.domain.model.MovieEntity;

import java.util.List;

import io.reactivex.Single;

public interface MovieRepository {

    Single<List<MovieEntity>> getMovies(Integer pageNumber);

    Single<MovieEntity> getMovie(Integer movieId);

    void insertMovie(MovieEntity movieEntity);

    void insertMovies(List<MovieEntity> movieEntities);

}
