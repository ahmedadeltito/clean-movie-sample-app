package com.ahmedadel.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ahmedadel.data.local.model.TVLocal;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TVDao {

    @Query("SELECT * FROM tv ORDER BY name ASC")
    Single<List<TVLocal>> getTVs();

    @Query("SELECT * FROM tv WHERE id = :tvId")
    Single<TVLocal> getTV(Integer tvId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTV(TVLocal tv);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTVs(List<TVLocal> tvs);

}
