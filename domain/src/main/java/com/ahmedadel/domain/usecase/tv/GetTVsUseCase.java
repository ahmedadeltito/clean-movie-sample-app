package com.ahmedadel.domain.usecase.tv;

import com.ahmedadel.domain.executor.PostExecutionThread;
import com.ahmedadel.domain.executor.ThreadExecutor;
import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.domain.repository.TVRepository;
import com.ahmedadel.domain.usecase.UseCase;

import java.util.List;

import io.reactivex.Single;

public abstract class GetTVsUseCase extends UseCase<List<TVEntity>, Integer> {

    private TVRepository tvRepository;

    GetTVsUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Single<List<TVEntity>> buildUseCaseObservable(Integer pageNumber) {
        return tvRepository.getTVs(pageNumber);
    }

}

