package com.ahmedadel.cleanmoviesampleapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ahmedadel.presentation.PresentationInjection;
import com.ahmedadel.presentation.model.viewstate.movie.MovieListViewState;
import com.ahmedadel.presentation.viewmodel.home.HomeViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeViewModel homeViewModel = ViewModelProviders.of(this,
                PresentationInjection.provideHomeViewModelFactory(this)).get(HomeViewModel.class);

        homeViewModel.getMovies().observe(this, new Observer<MovieListViewState>() {
            @Override
            public void onChanged(@Nullable MovieListViewState movieListViewState) {
                MovieListViewState movieListViewState1 = movieListViewState;
                Log.d("MovieListViewState", movieListViewState.toString());
            }
        });

        homeViewModel.callMovies();

    }
}
