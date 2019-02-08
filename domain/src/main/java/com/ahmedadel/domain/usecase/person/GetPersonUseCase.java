package com.ahmedadel.domain.usecase.person;

import com.ahmedadel.domain.executor.PostExecutionThread;
import com.ahmedadel.domain.executor.ThreadExecutor;
import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.domain.repository.PersonRepository;
import com.ahmedadel.domain.usecase.UseCase;

import io.reactivex.Single;

public abstract class GetPersonUseCase extends UseCase<PersonEntity, Integer> {

    private PersonRepository personRepository;

    GetPersonUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Single<PersonEntity> buildUseCaseObservable(Integer personId) {
        return personRepository.getPerson(personId);
    }

}
