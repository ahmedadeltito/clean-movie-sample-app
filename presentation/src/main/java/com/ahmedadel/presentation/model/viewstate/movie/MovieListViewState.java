package com.ahmedadel.presentation.model.viewstate.movie;

import com.ahmedadel.presentation.model.MovieUIModel;
import com.ahmedadel.presentation.model.viewstate.NetworkState;

import java.util.List;

public class MovieListViewState {

    private NetworkState networkState;
    private List<MovieUIModel> movies;

    public NetworkState getNetworkState() {
        return networkState;
    }

    public void setNetworkState(NetworkState networkState) {
        this.networkState = networkState;
    }

    public List<MovieUIModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieUIModel> movies) {
        this.movies = movies;
    }
}
