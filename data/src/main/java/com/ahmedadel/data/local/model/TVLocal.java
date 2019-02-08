package com.ahmedadel.data.local.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tv")
public class TVLocal {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "first_air_date")
    public String firstAirDate;

    @ColumnInfo(name = "overview")
    public String overview;

    @ColumnInfo(name = "original_language")
    public String originalLanguage;

    @ColumnInfo(name = "poster_path")
    public String posterPath;

    @ColumnInfo(name = "backdrop_path")
    public String backdropPath;

    @ColumnInfo(name = "popularity")
    public double popularity;

    @ColumnInfo(name = "vote_average")
    public double voteAverage;

    @ColumnInfo(name = "original_name")
    public String originalName;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "vote_count")
    public int voteCount;

}
