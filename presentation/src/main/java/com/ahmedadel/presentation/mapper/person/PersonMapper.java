package com.ahmedadel.presentation.mapper.person;

import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.presentation.model.PersonUIModel;

import java.util.List;

public interface PersonMapper {

    PersonUIModel mapToUI(PersonEntity personEntity);

    List<PersonUIModel> mapDomainListToUI(List<PersonEntity> personEntities);

}
