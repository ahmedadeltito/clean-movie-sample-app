package com.ahmedadel.presentation.mapper.movie;

import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.presentation.model.MovieUIModel;

import java.util.ArrayList;
import java.util.List;

public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieUIModel mapToUI(MovieEntity movieEntity) {
        MovieUIModel movieUIModel = new MovieUIModel();
        movieUIModel.setTitle(movieEntity.getTitle());
        movieUIModel.setAdult(movieEntity.isAdult());
        movieUIModel.setOriginalTitle(movieEntity.getOriginalTitle());
        movieUIModel.setOriginalLanguage(movieEntity.getOriginalLanguage());
        movieUIModel.setOverview(movieEntity.getOverview());
        movieUIModel.setPosterPath(movieEntity.getPosterPath());
        movieUIModel.setReleaseDate(movieEntity.getReleaseDate());
        movieUIModel.setVoteAverage(movieEntity.getVoteAverage());
        return movieUIModel;
    }

    @Override
    public List<MovieUIModel> mapDomainListToUI(List<MovieEntity> movieEntities) {
        List<MovieUIModel> movieUIModels = new ArrayList<>();
        for (int i = 0; i < movieEntities.size(); i++) {
            movieUIModels.add(mapToUI(movieEntities.get(i)));
        }
        return movieUIModels;
    }
}
