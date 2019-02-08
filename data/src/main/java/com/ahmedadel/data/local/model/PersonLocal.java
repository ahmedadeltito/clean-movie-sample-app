package com.ahmedadel.data.local.model;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "person")
public class PersonLocal {

    @ColumnInfo(name ="known_for")
    public List<KnownForLocal> knownFor;

    @ColumnInfo(name ="popularity")
    public double popularity;

    @ColumnInfo(name ="name")
    public String name;

    @ColumnInfo(name ="profile_path")
    public String profilePath;

    @ColumnInfo(name ="id")
    public int id;

    @ColumnInfo(name ="adult")
    public boolean adult;

}
