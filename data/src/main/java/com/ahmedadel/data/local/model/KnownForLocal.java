package com.ahmedadel.data.local.model;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "known_for")
public class KnownForLocal {

    @PrimaryKey
    public int id;

    @ColumnInfo(name ="overview")
    public String overview;

    @ColumnInfo(name ="original_language")
    public String originalLanguage;

    @ColumnInfo(name ="original_title")
    public String originalTitle;

    @ColumnInfo(name ="video")
    public boolean video;

    @ColumnInfo(name ="title")
    public String title;

    @ColumnInfo(name ="genre_ids")
    public List<Integer> genreIds;

    @ColumnInfo(name ="poster_path")
    public String posterPath;

    @ColumnInfo(name ="backdrop_path")
    public String backdropPath;

    @ColumnInfo(name ="release_date")
    public String releaseDate;

    @ColumnInfo(name ="media_type")
    public String mediaType;

    @ColumnInfo(name ="popularity")
    public double popularity;

    @ColumnInfo(name ="vote_average")
    public double voteAverage;

    @ColumnInfo(name ="adult")
    public boolean adult;

    @ColumnInfo(name ="vote_count")
    public int voteCount;

}
