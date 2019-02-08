package com.ahmedadel.domain.repository;

import com.ahmedadel.domain.model.TVEntity;

import java.util.List;

import io.reactivex.Single;

public interface TVRepository {

    Single<List<TVEntity>> getTVs(Integer pageNumber);

    Single<TVEntity> getTV(Integer tvId);

    void insertTV(TVEntity tvEntity);

    void insertTVs(List<TVEntity> tvEntities);

}
