package com.ahmedadel.presentation.mapper.person;

import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.presentation.model.PersonUIModel;

import java.util.ArrayList;
import java.util.List;

public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonUIModel mapToUI(PersonEntity personEntity) {
        PersonUIModel personUIModel = new PersonUIModel();
        personUIModel.setId(personEntity.getId());
        personUIModel.setName(personEntity.getName());
        personUIModel.setAdult(personEntity.isAdult());
        personUIModel.setPopularity(personEntity.getPopularity());
        personUIModel.setProfilePath(personEntity.getProfilePath());
        return personUIModel;
    }

    @Override
    public List<PersonUIModel> mapDomainListToUI(List<PersonEntity> personEntities) {
        List<PersonUIModel> personUIModels = new ArrayList<>();
        for (int i = 0; i < personEntities.size(); i++) {
            personUIModels.add(mapToUI(personEntities.get(i)));
        }
        return personUIModels;
    }
}
