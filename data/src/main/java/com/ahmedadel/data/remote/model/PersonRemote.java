package com.ahmedadel.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class PersonRemote {

    @SerializedName("id")
    private int id;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("name")
    private String name;

    @SerializedName("profile_path")
    private String profilePath;

    @SerializedName("adult")
    private boolean adult;

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isAdult() {
        return adult;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        return
                "PersonRemote{" +
                        ",popularity = '" + popularity + '\'' +
                        ",name = '" + name + '\'' +
                        ",profile_path = '" + profilePath + '\'' +
                        ",id = '" + id + '\'' +
                        ",adult = '" + adult + '\'' +
                        "}";
    }
}