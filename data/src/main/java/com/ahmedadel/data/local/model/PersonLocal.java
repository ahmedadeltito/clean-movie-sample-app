package com.ahmedadel.data.local.model;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class PersonLocal {

    @PrimaryKey
    public int id;

    @ColumnInfo(name ="known_for")
    public List<MovieLocal> knownFor;

    @ColumnInfo(name ="popularity")
    public double popularity;

    @ColumnInfo(name ="name")
    public String name;

    @ColumnInfo(name ="profile_path")
    public String profilePath;

    @ColumnInfo(name ="adult")
    public boolean adult;

}
