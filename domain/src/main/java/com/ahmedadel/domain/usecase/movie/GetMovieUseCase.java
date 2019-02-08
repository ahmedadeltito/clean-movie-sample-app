package com.ahmedadel.domain.usecase.movie;

import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.repository.MovieRepository;

import io.reactivex.Flowable;

public class GetMovieUseCase {

    private MovieRepository movieRepository;

    public GetMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flowable<MovieEntity> getMovie(Integer movieId) {
        return movieRepository.getMovie(movieId);
    }

}
