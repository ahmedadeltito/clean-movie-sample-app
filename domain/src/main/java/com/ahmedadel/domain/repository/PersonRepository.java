package com.ahmedadel.domain.repository;

import com.ahmedadel.domain.model.PersonEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface PersonRepository {

    Flowable<List<PersonEntity>> getPersons(Integer pageNumber);

    Flowable<PersonEntity> getPerson(Integer personId);

    void insertPerson(PersonEntity personEntity);

    void insertPersons(List<PersonEntity> personEntities);

}
