package com.ahmedadel.data.local.dao;

import com.ahmedadel.data.local.model.PersonLocal;

import java.util.List;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

public interface PersonDao {

    @Query("SELECT * FROM person ORDER BY name ASC")
    Single<List<PersonLocal>> getPersons();

    @Query("SELECT * FROM person WHERE id = :personId")
    Single<PersonLocal> getPerson(Integer personId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(PersonLocal person);

    @Delete
    void delete(PersonLocal person);

    @Query("DELETE FROM person")
    Integer deleteAll();

}
