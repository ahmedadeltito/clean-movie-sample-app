package com.ahmedadel.domain.usecase.person;

import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.domain.repository.PersonRepository;

import io.reactivex.Single;

public class GetPersonUseCase {

    private PersonRepository personRepository;

    public GetPersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Single<PersonEntity> getPerson(Integer personId) {
        return personRepository.getPerson(personId);
    }

}
