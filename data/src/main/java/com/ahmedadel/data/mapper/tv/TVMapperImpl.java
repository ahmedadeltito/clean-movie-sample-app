package com.ahmedadel.data.mapper.tv;

import com.ahmedadel.data.local.model.TVLocal;
import com.ahmedadel.data.remote.model.TVRemote;
import com.ahmedadel.domain.model.TVEntity;

import java.util.ArrayList;
import java.util.List;

public class TVMapperImpl implements TVMapper {

    @Override
    public TVEntity mapToDomain(TVLocal tvLocal) {
        TVEntity tvEntity = new TVEntity();
        tvEntity.setId(tvLocal.id);
        tvEntity.setName(tvLocal.name);
        tvEntity.setOriginalLanguage(tvLocal.originalLanguage);
        tvEntity.setOriginalName(tvLocal.originalName);
        tvEntity.setOverview(tvLocal.overview);
        tvEntity.setPosterPath(tvLocal.posterPath);
        tvEntity.setVoteAverage(tvLocal.voteAverage);
        tvEntity.setVoteCount(tvLocal.voteCount);
        return tvEntity;
    }

    @Override
    public TVEntity mapToDomain(TVRemote tvRemote) {
        TVEntity tvEntity = new TVEntity();
        tvEntity.setId(tvRemote.getId());
        tvEntity.setName(tvRemote.getName());
        tvEntity.setOriginalLanguage(tvRemote.getOriginalLanguage());
        tvEntity.setOriginalName(tvRemote.getOriginalName());
        tvEntity.setOverview(tvRemote.getOverview());
        tvEntity.setPosterPath(tvRemote.getPosterPath());
        tvEntity.setVoteAverage(tvRemote.getVoteAverage());
        tvEntity.setVoteCount(tvRemote.getVoteCount());
        return tvEntity;
    }

    @Override
    public List<TVEntity> mapLocalListToDomain(List<TVLocal> tvLocals) {
        List<TVEntity> tvEntities = new ArrayList<>();
        for (int i = 0; i < tvLocals.size(); i++) {
            tvEntities.add(mapToDomain(tvLocals.get(i)));
        }
        return tvEntities;
    }

    @Override
    public List<TVEntity> mapRemoteListToDomain(List<TVRemote> tvRemotes) {
        List<TVEntity> tvEntities = new ArrayList<>();
        for (int i = 0; i < tvRemotes.size(); i++) {
            tvEntities.add(mapToDomain(tvRemotes.get(i)));
        }
        return tvEntities;
    }

    @Override
    public TVLocal mapToLocal(TVEntity tvEntity) {
        TVLocal tvLocal = new TVLocal();
        tvLocal.id = tvEntity.getId();
        tvLocal.name = tvEntity.getName();
        tvLocal.originalLanguage = tvEntity.getOriginalLanguage();
        tvLocal.originalName = tvEntity.getOriginalName();
        tvLocal.overview = tvEntity.getOverview();
        tvLocal.posterPath = tvEntity.getPosterPath();
        tvLocal.voteAverage = tvEntity.getVoteAverage();
        tvLocal.voteCount = tvEntity.getVoteCount();
        return tvLocal;
    }

    @Override
    public List<TVLocal> mapEntityListToLocal(List<TVEntity> tvEntities) {
        List<TVLocal> tvLocals = new ArrayList<>();
        for (int i = 0; i < tvEntities.size(); i++) {
            tvLocals.add(mapToLocal(tvEntities.get(i)));
        }
        return tvLocals;
    }
}
