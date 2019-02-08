package com.ahmedadel.domain.repository;

import com.ahmedadel.domain.model.PersonEntity;

import java.util.List;

import io.reactivex.Single;

public interface PersonRepository {

    Single<List<PersonEntity>> getPersons(Integer pageNumber);

    Single<PersonEntity> getPerson(Integer personId);

    void insertPerson(PersonEntity personEntity);

    void insertPersons(List<PersonEntity> personEntities);

}
