package com.ahmedadel.data.repository;

import com.ahmedadel.data.local.dao.PersonDao;
import com.ahmedadel.data.mapper.person.PersonMapper;
import com.ahmedadel.data.mapper.person.PersonMapperImpl;
import com.ahmedadel.data.remote.client.MovieAppAPI;
import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.domain.repository.PersonRepository;

import java.util.List;

import io.reactivex.Single;

public class PersonRepositoryImpl implements PersonRepository {

    private PersonDao local;
    private MovieAppAPI remote;

    private PersonMapper mapper;

    public PersonRepositoryImpl(PersonDao local, MovieAppAPI remote) {
        this.local = local;
        this.remote = remote;
        this.mapper = new PersonMapperImpl();
    }

    @Override
    public Single<List<PersonEntity>> getPersons(Integer pageNumber) {
        Single<List<PersonEntity>> localPersons =
                local.getPersons().map(personLocals -> mapper.mapLocalListToDomain(personLocals));
        Single<List<PersonEntity>> remotePersons =
                remote.getPersons(pageNumber).map(personListRemote -> {
                    List<PersonEntity> personEntities = mapper.mapRemoteListToDomain(personListRemote.getPersons());
                    if (pageNumber == 1)
                        insertPersons(personEntities);
                    return personEntities;
                });
        if (pageNumber == 1)
            return Single.concat(localPersons, remotePersons).singleOrError();
        return remotePersons;
    }

    @Override
    public Single<PersonEntity> getPerson(Integer personId) {
        Single<PersonEntity> localPerson =
                local.getPerson(personId).map(personLocal -> {
                    PersonEntity personEntity = mapper.mapToDomain(personLocal);
                    insertPerson(personEntity);
                    return personEntity;
                });
        Single<PersonEntity> remotePerson =
                remote.getPerson(personId).map(personRemote -> mapper.mapToDomain(personRemote));
        return Single.concat(localPerson, remotePerson).singleOrError();
    }

    @Override
    public void insertPerson(PersonEntity personEntity) {
        local.insertPerson(mapper.mapToLocal(personEntity));
    }

    @Override
    public void insertPersons(List<PersonEntity> personEntities) {
        local.insertPersons(mapper.mapEntityListToLocal(personEntities));
    }

}
