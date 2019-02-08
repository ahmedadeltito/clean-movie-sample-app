package com.ahmedadel.domain.repository;

import com.ahmedadel.domain.model.MovieEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface MovieRepository {

    Flowable<List<MovieEntity>> getMovies(Integer pageNumber);

    Flowable<MovieEntity> getMovie(Integer movieId);

    void insertMovie(MovieEntity movieEntity);

}
