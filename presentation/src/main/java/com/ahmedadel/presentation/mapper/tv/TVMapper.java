package com.ahmedadel.presentation.mapper.tv;

import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.presentation.model.TVUIModel;

import java.util.List;

public interface TVMapper {

    TVUIModel mapToUI(TVEntity tvEntity);

    List<TVUIModel> mapDomainListToUI(List<TVEntity> tvEntities);

}
