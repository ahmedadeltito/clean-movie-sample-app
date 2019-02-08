package com.ahmedadel.data.local.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "movie")
public class MovieLocal {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "overview")
    public String overview;

    @ColumnInfo(name = "original_language")
    public String originalLanguage;

    @ColumnInfo(name = "original_title")
    public String originalTitle;

    @ColumnInfo(name = "video")
    public boolean video;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "poster_path")
    public String posterPath;

    @ColumnInfo(name = "backdrop_path")
    public String backdropPath;

    @ColumnInfo(name = "release_date")
    public String releaseDate;

    @ColumnInfo(name = "popularity")
    public double popularity;

    @ColumnInfo(name = "vote_average")
    public double voteAverage;

    @ColumnInfo(name = "adult")
    public boolean adult;

    @ColumnInfo(name = "vote_count")
    public int voteCount;

}
