package com.ahmedadel.domain.usecase.person;

import com.ahmedadel.domain.executor.PostExecutionThread;
import com.ahmedadel.domain.executor.ThreadExecutor;
import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.domain.repository.PersonRepository;
import com.ahmedadel.domain.usecase.UseCase;

import java.util.List;

import io.reactivex.Single;

public abstract class GetPersonsUseCase extends UseCase<List<PersonEntity>, Integer> {

    private PersonRepository personRepository;

    GetPersonsUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Single<List<PersonEntity>> buildUseCaseObservable(Integer pageNumber) {
        return personRepository.getPersons(pageNumber);
    }

}
