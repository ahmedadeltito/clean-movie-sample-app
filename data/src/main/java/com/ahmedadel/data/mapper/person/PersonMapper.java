package com.ahmedadel.data.mapper.person;

import com.ahmedadel.data.local.model.PersonLocal;
import com.ahmedadel.data.remote.model.PersonRemote;
import com.ahmedadel.domain.model.PersonEntity;

import java.util.List;

public interface PersonMapper {

    PersonEntity mapToDomain(PersonLocal personLocal);

    PersonEntity mapToDomain(PersonRemote personRemote);

    List<PersonEntity> mapLocalListToDomain(List<PersonLocal> personLocals);

    List<PersonEntity> mapRemoteListToDomain(List<PersonRemote> personRemotes);

    PersonLocal mapToLocal(PersonEntity personEntity);

    List<PersonLocal> mapEntityListToLocal(List<PersonEntity> personEntities);

}
