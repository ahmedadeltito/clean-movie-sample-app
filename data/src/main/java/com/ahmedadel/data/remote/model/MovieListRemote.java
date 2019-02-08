package com.ahmedadel.data.remote.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MovieListRemote {

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<MovieRemote> movies;

	@SerializedName("total_results")
	private int totalResults;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setMovies(List<MovieRemote> movies){
		this.movies = movies;
	}

	public List<MovieRemote> getMovies(){
		return movies;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@SuppressWarnings("NullableProblems")
	@Override
 	public String toString(){
		return 
			"MovieListRemote{" +
			"page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + movies + '\'' +
			",total_results = '" + totalResults + '\'' + 
			"}";
		}
}