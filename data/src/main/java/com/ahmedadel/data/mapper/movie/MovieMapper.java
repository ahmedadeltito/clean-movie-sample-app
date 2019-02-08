package com.ahmedadel.data.mapper.movie;

import com.ahmedadel.data.local.model.MovieLocal;
import com.ahmedadel.data.remote.model.MovieRemote;
import com.ahmedadel.domain.model.MovieEntity;

import java.util.List;

public interface MovieMapper {

    MovieEntity mapToDomain(MovieLocal movieLocal);

    MovieEntity mapToDomain(MovieRemote movieRemote);

    List<MovieEntity> mapLocalListToDomain(List<MovieLocal> movieLocals);

    List<MovieEntity> mapRemoteListToDomain(List<MovieRemote> movieRemotes);

    MovieLocal mapToLocal(MovieEntity movieEntity);

}
