package com.ahmedadel.domain.usecase.tv;

import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.domain.repository.TVRepository;

import io.reactivex.Flowable;

public class GetTVUseCase {

    private TVRepository tvRepository;

    public GetTVUseCase(TVRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    public Flowable<TVEntity> getTV(Integer tvId) {
        return tvRepository.getTV(tvId);
    }

}
