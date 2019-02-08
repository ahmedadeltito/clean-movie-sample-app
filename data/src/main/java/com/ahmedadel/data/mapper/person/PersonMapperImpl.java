package com.ahmedadel.data.mapper.person;

import com.ahmedadel.data.local.model.MovieLocal;
import com.ahmedadel.data.local.model.PersonLocal;
import com.ahmedadel.data.mapper.movie.MovieMapper;
import com.ahmedadel.data.mapper.movie.MovieMapperImpl;
import com.ahmedadel.data.remote.model.PersonRemote;
import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.model.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity mapToDomain(PersonLocal personLocal) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        MovieMapper movieMapper = new MovieMapperImpl();
        for (int i = 0; i < personLocal.knownFor.size(); i++) {
            movieEntities.add(movieMapper.mapToDomain(personLocal.knownFor.get(i)));
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personLocal.id);
        personEntity.setName(personLocal.name);
        personEntity.setAdult(personLocal.adult);
        personEntity.setKnownFor(movieEntities);
        personEntity.setPopularity(personLocal.popularity);
        personEntity.setProfilePath(personLocal.profilePath);
        return personEntity;
    }

    @Override
    public PersonEntity mapToDomain(PersonRemote personRemote) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        MovieMapper movieMapper = new MovieMapperImpl();
        for (int i = 0; i < personRemote.getKnownFor().size(); i++) {
            movieEntities.add(movieMapper.mapToDomain(personRemote.getKnownFor().get(i)));
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personRemote.getId());
        personEntity.setName(personRemote.getName());
        personEntity.setAdult(personRemote.isAdult());
        personEntity.setKnownFor(movieEntities);
        personEntity.setPopularity(personRemote.getPopularity());
        personEntity.setProfilePath(personRemote.getProfilePath());
        return personEntity;
    }

    @Override
    public List<PersonEntity> mapLocalListToDomain(List<PersonLocal> personLocals) {
        List<PersonEntity> personEntities = new ArrayList<>();
        for (int i = 0; i < personLocals.size(); i++) {
            personEntities.add(mapToDomain(personLocals.get(i)));
        }
        return personEntities;
    }

    @Override
    public List<PersonEntity> mapRemoteListToDomain(List<PersonRemote> personRemotes) {
        List<PersonEntity> personEntities = new ArrayList<>();
        for (int i = 0; i < personRemotes.size(); i++) {
            personEntities.add(mapToDomain(personRemotes.get(i)));
        }
        return personEntities;
    }

    @Override
    public PersonLocal mapToLocal(PersonEntity personEntity) {
        List<MovieLocal> movieLocals = new ArrayList<>();
        MovieMapper movieMapper = new MovieMapperImpl();
        for (int i = 0; i < personEntity.getKnownFor().size(); i++) {
            movieLocals.add(movieMapper.mapToLocal(personEntity.getKnownFor().get(i)));
        }

        PersonLocal personLocal = new PersonLocal();
        personLocal.id = personEntity.getId();
        personLocal.name = personEntity.getName();
        personLocal.adult = personEntity.isAdult();
        personLocal.knownFor = movieLocals;
        personLocal.popularity = personEntity.getPopularity();
        personLocal.profilePath = personEntity.getProfilePath();
        return personLocal;
    }

    @Override
    public List<PersonLocal> mapEntityListToLocal(List<PersonEntity> personEntities) {
        List<PersonLocal> personLocals = new ArrayList<>();
        for (int i = 0; i < personEntities.size(); i++) {
            personLocals.add(mapToLocal(personEntities.get(i)));
        }
        return personLocals;
    }
}
