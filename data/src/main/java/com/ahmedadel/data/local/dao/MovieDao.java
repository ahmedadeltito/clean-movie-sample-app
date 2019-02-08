package com.ahmedadel.data.local.dao;

import com.ahmedadel.data.local.model.MovieLocal;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY title ASC")
    Single<List<MovieLocal>> getMovies();

    @Query("SELECT * FROM movie WHERE id = :movieId")
    Single<MovieLocal> getMovie(Integer movieId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieLocal movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieLocal> movie);

}
