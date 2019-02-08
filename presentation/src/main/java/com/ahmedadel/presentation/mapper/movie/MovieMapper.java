package com.ahmedadel.presentation.mapper.movie;

import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.presentation.model.MovieUIModel;

import java.util.List;

public interface MovieMapper {

    MovieUIModel mapToUI(MovieEntity movieEntity);

    List<MovieUIModel> mapDomainListToUI(List<MovieEntity> movieEntities);

}
