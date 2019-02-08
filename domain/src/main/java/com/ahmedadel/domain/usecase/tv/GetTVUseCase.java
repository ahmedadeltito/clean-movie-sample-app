package com.ahmedadel.domain.usecase.tv;

import com.ahmedadel.domain.executor.PostExecutionThread;
import com.ahmedadel.domain.executor.ThreadExecutor;
import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.domain.repository.TVRepository;
import com.ahmedadel.domain.usecase.UseCase;

import io.reactivex.Single;

public abstract class GetTVUseCase extends UseCase<TVEntity, Integer> {

    private TVRepository tvRepository;

    GetTVUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Single<TVEntity> buildUseCaseObservable(Integer tvId) {
        return tvRepository.getTV(tvId);
    }

}
