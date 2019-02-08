package com.ahmedadel.domain.usecase.movie;

import com.ahmedadel.domain.executor.PostExecutionThread;
import com.ahmedadel.domain.executor.ThreadExecutor;
import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.repository.MovieRepository;
import com.ahmedadel.domain.usecase.UseCase;

import io.reactivex.Single;

public abstract class GetMovieUseCase extends UseCase<MovieEntity, Integer> {

    private MovieRepository movieRepository;

    GetMovieUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Single<MovieEntity> buildUseCaseObservable(Integer movieId) {
        return movieRepository.getMovie(movieId);
    }

}
