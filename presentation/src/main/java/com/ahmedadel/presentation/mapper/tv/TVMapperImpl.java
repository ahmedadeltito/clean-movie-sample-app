package com.ahmedadel.presentation.mapper.tv;

import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.presentation.model.TVUIModel;

import java.util.ArrayList;
import java.util.List;

public class TVMapperImpl implements TVMapper {

    @Override
    public TVUIModel mapToUI(TVEntity tvEntity) {
        TVUIModel tvUIModels = new TVUIModel();
        tvUIModels.setId(tvEntity.getId());
        tvUIModels.setName(tvEntity.getName());
        tvUIModels.setOriginalLanguage(tvEntity.getOriginalLanguage());
        tvUIModels.setOriginalName(tvEntity.getOriginalName());
        tvUIModels.setOverview(tvEntity.getOverview());
        tvUIModels.setPosterPath(tvEntity.getPosterPath());
        tvUIModels.setVoteCount(tvEntity.getVoteCount());
        return tvUIModels;
    }

    @Override
    public List<TVUIModel> mapDomainListToUI(List<TVEntity> tvEntities) {
        List<TVUIModel> tvUIModels = new ArrayList<>();
        for (int i = 0; i < tvEntities.size(); i++) {
            tvUIModels.add(mapToUI(tvEntities.get(i)));
        }
        return tvUIModels;
    }
}
