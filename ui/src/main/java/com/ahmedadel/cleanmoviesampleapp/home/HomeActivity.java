package com.ahmedadel.cleanmoviesampleapp.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ahmedadel.cleanmoviesampleapp.R;
import com.ahmedadel.cleanmoviesampleapp.home.adapter.HomeMovieAdapter;
import com.ahmedadel.cleanmoviesampleapp.home.adapter.HomePersonAdapter;
import com.ahmedadel.cleanmoviesampleapp.home.adapter.HomeTvAdapter;
import com.ahmedadel.presentation.PresentationInjection;
import com.ahmedadel.presentation.model.viewstate.movie.MovieListViewState;
import com.ahmedadel.presentation.model.viewstate.person.PersonListViewState;
import com.ahmedadel.presentation.model.viewstate.tv.TVListViewState;
import com.ahmedadel.presentation.viewmodel.home.HomeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.movie_more_btn)
    Button movieMoreBtn;
    @BindView(R.id.movie_recycler_view_list)
    RecyclerView movieRecyclerViewList;
    @BindView(R.id.movie_loading)
    ProgressBar movieProgressBar;

    @BindView(R.id.person_more_btn)
    Button personMoreBtn;
    @BindView(R.id.person_recycler_view_list)
    RecyclerView personRecyclerViewList;
    @BindView(R.id.person_loading)
    ProgressBar personProgressBar;

    @BindView(R.id.tv_more_btn)
    Button tvMoreBtn;
    @BindView(R.id.tv_recycler_view_list)
    RecyclerView tvRecyclerViewList;
    @BindView(R.id.tv_loading)
    ProgressBar tvProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        movieRecyclerViewList.setItemAnimator(new DefaultItemAnimator());
        movieRecyclerViewList.setHasFixedSize(true);

        personRecyclerViewList.setItemAnimator(new DefaultItemAnimator());
        personRecyclerViewList.setHasFixedSize(true);

        tvRecyclerViewList.setItemAnimator(new DefaultItemAnimator());
        tvRecyclerViewList.setHasFixedSize(true);

        HomeViewModel homeViewModel = ViewModelProviders.of(this,
                PresentationInjection.provideHomeViewModelFactory(this)).get(HomeViewModel.class);

        homeViewModel.getMovies().observe(this, movieListViewState -> {
            if (movieListViewState != null)
                showMovies(movieListViewState);
        });

        homeViewModel.getPersons().observe(this, personListViewState -> {
            if (personListViewState != null)
                showPersons(personListViewState);
        });

        homeViewModel.getTVs().observe(this, tvListViewState -> {
            if (tvListViewState != null)
                showTvs(tvListViewState);
        });

        homeViewModel.callMovies();
        homeViewModel.callPersons();
        homeViewModel.callTVs();
    }

    private void showMovies(MovieListViewState movieListViewState) {
        switch (movieListViewState.getNetworkState().getViewStatus()) {
            case RUNNING:
                movieProgressBar.setVisibility(View.VISIBLE);
                break;
            case SUCCESS:
                movieProgressBar.setVisibility(View.GONE);
                movieRecyclerViewList.setAdapter(new HomeMovieAdapter(movieListViewState.getMovies()));
                break;
            case FAILED:
                movieProgressBar.setVisibility(View.GONE);
                Toast.makeText(this,
                        movieListViewState.getNetworkState().getMessage(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showPersons(PersonListViewState personListViewState) {
        switch (personListViewState.getNetworkState().getViewStatus()) {
            case RUNNING:
                personProgressBar.setVisibility(View.VISIBLE);
                break;
            case SUCCESS:
                personProgressBar.setVisibility(View.GONE);
                personRecyclerViewList.setAdapter(new HomePersonAdapter(personListViewState.getPersons()));
                break;
            case FAILED:
                personProgressBar.setVisibility(View.GONE);
                Toast.makeText(this,
                        personListViewState.getNetworkState().getMessage(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showTvs(TVListViewState tvListViewState) {
        switch (tvListViewState.getNetworkState().getViewStatus()) {
            case RUNNING:
                tvProgressBar.setVisibility(View.VISIBLE);
                break;
            case SUCCESS:
                tvProgressBar.setVisibility(View.GONE);
                tvRecyclerViewList.setAdapter(new HomeTvAdapter(tvListViewState.getTvs()));
                break;
            case FAILED:
                tvProgressBar.setVisibility(View.GONE);
                Toast.makeText(this,
                        tvListViewState.getNetworkState().getMessage(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
