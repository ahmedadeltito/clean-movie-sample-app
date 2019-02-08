package com.ahmedadel.domain.usecase.tv;

import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.domain.repository.TVRepository;

import java.util.List;

import io.reactivex.Single;

public class GetTVsUseCase {

    private TVRepository tvRepository;

    public GetTVsUseCase(TVRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    public Single<List<TVEntity>> getTVs(Integer pageNumber) {
        return tvRepository.getTVs(pageNumber);
    }

}

