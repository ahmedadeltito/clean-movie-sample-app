package com.ahmedadel.domain.repository;

import com.ahmedadel.domain.model.TVEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface TVRepository {

    Flowable<List<TVEntity>> getTVs(Integer pageNumber);

    Flowable<TVEntity> getTV(Integer tvId);

    void insertTV(TVEntity tvEntity);

    void insertTVs(List<TVEntity> tvEntities);

}
