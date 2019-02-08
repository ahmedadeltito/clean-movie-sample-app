package com.ahmedadel.domain.usecase.person;

import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.domain.repository.PersonRepository;

import java.util.List;

import io.reactivex.Single;

public class GetPersonsUseCase {

    private PersonRepository personRepository;

    public GetPersonsUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Single<List<PersonEntity>> getPersons(Integer pageNumber) {
        return personRepository.getPersons(pageNumber);
    }

}
