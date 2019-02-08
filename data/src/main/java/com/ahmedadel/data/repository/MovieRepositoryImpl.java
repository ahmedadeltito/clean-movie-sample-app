package com.ahmedadel.data.repository;

import com.ahmedadel.data.local.dao.MovieDao;
import com.ahmedadel.data.mapper.movie.MovieMapper;
import com.ahmedadel.data.mapper.movie.MovieMapperImpl;
import com.ahmedadel.data.remote.client.MovieAppAPI;
import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.repository.MovieRepository;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieDao local;
    private MovieAppAPI remote;

    private MovieMapper mapper;

    public MovieRepositoryImpl(MovieDao local, MovieAppAPI remote) {
        this.local = local;
        this.remote = remote;
        this.mapper = new MovieMapperImpl();
    }

    @Override
    public Flowable<List<MovieEntity>> getMovies(Integer pageNumber) {
        Single<List<MovieEntity>> localMovies =
                local.getMovies().map(movieLocals -> mapper.mapLocalListToDomain(movieLocals));
        Single<List<MovieEntity>> remoteMovies =
                remote.getMovies(pageNumber).map(
                        movieListRemote -> mapper.mapRemoteListToDomain(movieListRemote.getMovies()));
        if (pageNumber == 1)
            return Single.concat(localMovies, remoteMovies);
        return remoteMovies.toFlowable();
    }

    @Override
    public Flowable<MovieEntity> getMovie(Integer movieId) {
        Single<MovieEntity> localMovie =
                local.getMovie(movieId).map(movieLocal -> mapper.mapToDomain(movieLocal));
        Single<MovieEntity> remoteMovie =
                remote.getMovie(movieId).map(movieRemote -> {
                    MovieEntity movieEntity = mapper.mapToDomain(movieRemote);
                    insertMovie(movieEntity);
                    return mapper.mapToDomain(movieRemote);
                });
        return Single.concat(localMovie, remoteMovie);
    }

    @Override
    public void insertMovie(MovieEntity movieEntity) {
        local.insertMovie(mapper.mapToLocal(movieEntity));
    }

}
