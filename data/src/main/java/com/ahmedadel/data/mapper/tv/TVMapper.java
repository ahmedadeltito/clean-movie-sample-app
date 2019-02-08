package com.ahmedadel.data.mapper.tv;

import com.ahmedadel.data.local.model.TVLocal;
import com.ahmedadel.data.remote.model.TVRemote;
import com.ahmedadel.domain.model.TVEntity;

import java.util.List;

public interface TVMapper {

    TVEntity mapToDomain(TVLocal tvLocal);

    TVEntity mapToDomain(TVRemote tvRemote);

    List<TVEntity> mapLocalListToDomain(List<TVLocal> tvLocals);

    List<TVEntity> mapRemoteListToDomain(List<TVRemote> tvRemotes);

    TVLocal mapToLocal(TVEntity tvEntity);

    List<TVLocal> mapEntityListToLocal(List<TVEntity> tvEntities);

}
