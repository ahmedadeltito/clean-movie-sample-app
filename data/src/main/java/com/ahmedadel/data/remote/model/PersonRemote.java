package com.ahmedadel.data.remote.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PersonRemote {

	@SerializedName("known_for")
	private List<KnownForRemote> knownFor;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("name")
	private String name;

	@SerializedName("profile_path")
	private String profilePath;

	@SerializedName("id")
	private int id;

	@SerializedName("adult")
	private boolean adult;

	public void setKnownFor(List<KnownForRemote> knownFor){
		this.knownFor = knownFor;
	}

	public List<KnownForRemote> getKnownFor(){
		return knownFor;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProfilePath(String profilePath){
		this.profilePath = profilePath;
	}

	public String getProfilePath(){
		return profilePath;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	@SuppressWarnings("NullableProblems")
	@Override
 	public String toString(){
		return 
			"PersonRemote{" +
			"known_for = '" + knownFor + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",name = '" + name + '\'' + 
			",profile_path = '" + profilePath + '\'' + 
			",id = '" + id + '\'' + 
			",adult = '" + adult + '\'' + 
			"}";
		}
}