package com.ahmedadel.data.local.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "person")
public class PersonLocal {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "popularity")
    public double popularity;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "profile_path")
    public String profilePath;

    @ColumnInfo(name = "adult")
    public boolean adult;

}
