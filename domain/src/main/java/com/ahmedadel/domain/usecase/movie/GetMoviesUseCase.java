package com.ahmedadel.domain.usecase.movie;

import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.repository.MovieRepository;

import java.util.List;

import io.reactivex.Flowable;

public class GetMoviesUseCase {

    private MovieRepository movieRepository;

    public GetMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flowable<List<MovieEntity>> getMovies(Integer pageNumber) {
        return movieRepository.getMovies(pageNumber);
    }

}
