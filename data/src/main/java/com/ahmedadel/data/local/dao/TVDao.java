package com.ahmedadel.data.local.dao;

import com.ahmedadel.data.local.model.TVLocal;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface TVDao {

    @Query("SELECT * FROM tv ORDER BY name ASC")
    Single<List<TVLocal>> getTVs();

    @Query("SELECT * FROM tv WHERE id = :tvId")
    Single<TVLocal> getTV(Integer tvId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserTV(TVLocal tv);

    @Delete
    void delete(TVLocal tv);

    @Query("DELETE FROM tv")
    Integer deleteAll();

}
