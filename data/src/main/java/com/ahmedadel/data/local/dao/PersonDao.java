package com.ahmedadel.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ahmedadel.data.local.model.PersonLocal;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person ORDER BY name ASC")
    Single<List<PersonLocal>> getPersons();

    @Query("SELECT * FROM person WHERE id = :personId")
    Single<PersonLocal> getPerson(Integer personId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(PersonLocal person);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPersons(List<PersonLocal> persons);

}
