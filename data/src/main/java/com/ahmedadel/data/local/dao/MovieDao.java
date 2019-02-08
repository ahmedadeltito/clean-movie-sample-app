package com.ahmedadel.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ahmedadel.data.local.model.MovieLocal;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY title ASC")
    Single<List<MovieLocal>> getMovies();

    @Query("SELECT * FROM movie WHERE id = :movieId")
    Single<MovieLocal> getMovie(Integer movieId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieLocal movie);

}
