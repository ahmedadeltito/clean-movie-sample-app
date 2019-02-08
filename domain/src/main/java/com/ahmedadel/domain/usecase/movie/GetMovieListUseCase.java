package com.ahmedadel.domain.usecase.movie;

import com.ahmedadel.domain.executor.PostExecutionThread;
import com.ahmedadel.domain.executor.ThreadExecutor;
import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.repository.MovieRepository;
import com.ahmedadel.domain.usecase.UseCase;

import java.util.List;

import io.reactivex.Single;

public abstract class GetMovieListUseCase extends UseCase<List<MovieEntity>, Integer> {

    private MovieRepository movieRepository;

    GetMovieListUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Single<List<MovieEntity>> buildUseCaseObservable(Integer pageNumber) {
        return movieRepository.getMovies(pageNumber);
    }

}
