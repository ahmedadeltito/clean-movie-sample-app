package com.ahmedadel.data.mapper.movie;

import com.ahmedadel.data.local.model.MovieLocal;
import com.ahmedadel.data.remote.model.MovieRemote;
import com.ahmedadel.domain.model.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieEntity mapToDomain(MovieLocal movieLocal) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setAdult(movieLocal.adult);
        movieEntity.setOriginalLanguage(movieLocal.originalLanguage);
        movieEntity.setOriginalTitle(movieLocal.originalTitle);
        movieEntity.setOverview(movieLocal.overview);
        movieEntity.setPosterPath(movieLocal.posterPath);
        movieEntity.setReleaseDate(movieLocal.releaseDate);
        movieEntity.setTitle(movieLocal.title);
        movieEntity.setVoteAverage(movieLocal.voteAverage);
        movieEntity.setVoteCount(movieLocal.voteCount);
        return movieEntity;
    }

    @Override
    public MovieEntity mapToDomain(MovieRemote movieRemote) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setAdult(movieRemote.isAdult());
        movieEntity.setOriginalLanguage(movieRemote.getOriginalLanguage());
        movieEntity.setOriginalTitle(movieRemote.getOriginalTitle());
        movieEntity.setOverview(movieRemote.getOverview());
        movieEntity.setPosterPath(movieRemote.getPosterPath());
        movieEntity.setReleaseDate(movieRemote.getReleaseDate());
        movieEntity.setTitle(movieRemote.getTitle());
        movieEntity.setVoteAverage(movieRemote.getVoteAverage());
        movieEntity.setVoteCount(movieRemote.getVoteCount());
        return movieEntity;
    }

    @Override
    public List<MovieEntity> mapLocalListToDomain(List<MovieLocal> movieLocals) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        for (int i = 0; i < movieLocals.size(); i++) {
            movieEntities.add(mapToDomain(movieLocals.get(i)));
        }
        return movieEntities;
    }

    @Override
    public List<MovieEntity> mapRemoteListToDomain(List<MovieRemote> movieRemotes) {
        List<MovieEntity> movieEntities = new ArrayList<>();
        for (int i = 0; i < movieRemotes.size(); i++) {
            movieEntities.add(mapToDomain(movieRemotes.get(i)));
        }
        return movieEntities;
    }

    @Override
    public MovieLocal mapToLocal(MovieEntity movieEntity) {
        MovieLocal movieLocal = new MovieLocal();
        movieLocal.adult = movieEntity.isAdult();
        movieLocal.originalLanguage = movieEntity.getOriginalLanguage();
        movieLocal.originalTitle = movieEntity.getOriginalTitle();
        movieLocal.overview = movieEntity.getOverview();
        movieLocal.posterPath = movieEntity.getPosterPath();
        movieLocal.releaseDate = movieEntity.getReleaseDate();
        movieLocal.title = movieEntity.getTitle();
        movieLocal.voteAverage = movieEntity.getVoteAverage();
        movieLocal.voteCount = movieEntity.getVoteCount();
        return null;
    }

}
