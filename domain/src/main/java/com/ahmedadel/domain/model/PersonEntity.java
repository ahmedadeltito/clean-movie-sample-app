package com.ahmedadel.domain.model;

import java.util.List;

public class PersonEntity {

    private int id;

    private List<MovieEntity> knownFor;

    private double popularity;

    private String name;

    private String profilePath;

    private boolean adult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieEntity> getKnownFor() {
        return knownFor;
    }

    public void setKnownFor(List<MovieEntity> knownFor) {
        this.knownFor = knownFor;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
