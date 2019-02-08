package com.ahmedadel.data.repository;

import com.ahmedadel.data.local.dao.TVDao;
import com.ahmedadel.data.mapper.tv.TVMapper;
import com.ahmedadel.data.mapper.tv.TVMapperImpl;
import com.ahmedadel.data.remote.client.MovieAppAPI;
import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.domain.repository.TVRepository;

import java.util.List;

import io.reactivex.Single;

public class TVRepositoryImpl implements TVRepository {

    private TVDao local;
    private MovieAppAPI remote;

    private TVMapper mapper;

    public TVRepositoryImpl(TVDao local, MovieAppAPI remote) {
        this.local = local;
        this.remote = remote;
        this.mapper = new TVMapperImpl();
    }

    @Override
    public Single<List<TVEntity>> getTVs(Integer pageNumber) {
        Single<List<TVEntity>> localTVs =
                local.getTVs().map(tvLocals -> mapper.mapLocalListToDomain(tvLocals));
        Single<List<TVEntity>> remoteTVs =
                remote.getTVs(pageNumber).map(tvListRemote -> {
                    List<TVEntity> tvEntities = mapper.mapRemoteListToDomain(tvListRemote.getTVs());
                    if (pageNumber == 1)
                        insertTVs(tvEntities);
                    return tvEntities;
                });
        if (pageNumber == 1)
            return Single.concat(localTVs, remoteTVs).singleOrError();
        return remoteTVs;
    }

    @Override
    public Single<TVEntity> getTV(Integer tvId) {
        Single<TVEntity> localTV =
                local.getTV(tvId).map(tvLocal -> mapper.mapToDomain(tvLocal));
        Single<TVEntity> remoteTV =
                remote.getTV(tvId).map(tvRemote -> {
                    TVEntity tvEntity = mapper.mapToDomain(tvRemote);
                    insertTV(tvEntity);
                    return mapper.mapToDomain(tvRemote);
                });
        return Single.concat(localTV, remoteTV).singleOrError();
    }

    @Override
    public void insertTV(TVEntity tvEntity) {
        local.insertTV(mapper.mapToLocal(tvEntity));
    }

    @Override
    public void insertTVs(List<TVEntity> tvEntities) {
        local.insertTVs(mapper.mapEntityListToLocal(tvEntities));
    }

}
