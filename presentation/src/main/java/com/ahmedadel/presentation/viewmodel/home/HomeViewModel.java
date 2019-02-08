package com.ahmedadel.presentation.viewmodel.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ahmedadel.domain.model.MovieEntity;
import com.ahmedadel.domain.model.PersonEntity;
import com.ahmedadel.domain.model.TVEntity;
import com.ahmedadel.domain.usecase.movie.GetMoviesUseCase;
import com.ahmedadel.domain.usecase.person.GetPersonsUseCase;
import com.ahmedadel.domain.usecase.tv.GetTVsUseCase;
import com.ahmedadel.presentation.mapper.movie.MovieMapper;
import com.ahmedadel.presentation.mapper.movie.MovieMapperImpl;
import com.ahmedadel.presentation.mapper.person.PersonMapper;
import com.ahmedadel.presentation.mapper.person.PersonMapperImpl;
import com.ahmedadel.presentation.mapper.tv.TVMapper;
import com.ahmedadel.presentation.mapper.tv.TVMapperImpl;
import com.ahmedadel.presentation.model.viewstate.NetworkState;
import com.ahmedadel.presentation.model.viewstate.movie.MovieListViewState;
import com.ahmedadel.presentation.model.viewstate.person.PersonListViewState;
import com.ahmedadel.presentation.model.viewstate.tv.TVListViewState;
import com.ahmedadel.presentation.viewmodel.BaseViewModel;
import com.ahmedadel.presentation.viewmodel.DefaultSingle;

import java.util.List;

import io.reactivex.Scheduler;

public class HomeViewModel extends BaseViewModel {

    private GetMoviesUseCase getMoviesUseCase;
    private GetPersonsUseCase getPersonsUseCase;
    private GetTVsUseCase getTVsUseCase;

    private MutableLiveData<MovieListViewState> movieViewStateLiveData = new MutableLiveData<>();
    private MutableLiveData<PersonListViewState> personLViewStateLiveData = new MutableLiveData<>();
    private MutableLiveData<TVListViewState> tvListViewStateLiveData = new MutableLiveData<>();

    HomeViewModel(Scheduler subscribeOn, Scheduler observeOn,
                  GetMoviesUseCase getMoviesUseCase,
                  GetPersonsUseCase getPersonsUseCase,
                  GetTVsUseCase getTVsUseCase) {
        super(subscribeOn, observeOn);
        this.getMoviesUseCase = getMoviesUseCase;
        this.getPersonsUseCase = getPersonsUseCase;
        this.getTVsUseCase = getTVsUseCase;
    }

    public void callMovies() {
        execute(new GetMoviesSingle(), getMoviesUseCase.getMovies(1));
    }

    public void callPersons() {
        execute(new GetPersonsSingle(), getPersonsUseCase.getPersons(1));
    }

    public void callTVs() {
        execute(new GetTVsSingle(), getTVsUseCase.getTVs(1));
    }

    public LiveData<MovieListViewState> getMovies() {
        return movieViewStateLiveData;
    }

    public LiveData<PersonListViewState> getPersons() {
        return personLViewStateLiveData;
    }

    public LiveData<TVListViewState> getTVs() {
        return tvListViewStateLiveData;
    }

    class GetMoviesSingle extends DefaultSingle<List<MovieEntity>> {

        MovieListViewState movieListViewState = new MovieListViewState();

        @Override
        protected void onStart() {
            movieListViewState.setNetworkState(NetworkState.LOADING);
            movieViewStateLiveData.postValue(movieListViewState);
        }

        @Override
        public void onSuccess(List<MovieEntity> movieEntities) {
            MovieMapper movieMapper = new MovieMapperImpl();
            movieListViewState.setNetworkState(NetworkState.LOADED);
            movieListViewState.setMovies(movieMapper.mapDomainListToUI(movieEntities));
            movieViewStateLiveData.postValue(movieListViewState);
        }

        @Override
        public void onError(Throwable e) {
            movieListViewState.setNetworkState(NetworkState.error(e.getMessage()));
            movieViewStateLiveData.postValue(movieListViewState);
        }
    }

    class GetPersonsSingle extends DefaultSingle<List<PersonEntity>> {

        PersonListViewState personListViewState = new PersonListViewState();

        @Override
        protected void onStart() {
            personListViewState.setNetworkState(NetworkState.LOADING);
            personLViewStateLiveData.postValue(personListViewState);
        }

        @Override
        public void onSuccess(List<PersonEntity> personEntities) {
            PersonMapper personMapper = new PersonMapperImpl();
            personListViewState.setNetworkState(NetworkState.LOADED);
            personListViewState.setPersons(personMapper.mapDomainListToUI(personEntities));
            personLViewStateLiveData.postValue(personListViewState);
        }

        @Override
        public void onError(Throwable e) {
            personListViewState.setNetworkState(NetworkState.error(e.getMessage()));
            personLViewStateLiveData.postValue(personListViewState);
        }
    }

    class GetTVsSingle extends DefaultSingle<List<TVEntity>> {

        TVListViewState tvListViewState = new TVListViewState();

        @Override
        protected void onStart() {
            tvListViewState.setNetworkState(NetworkState.LOADING);
            tvListViewStateLiveData.postValue(tvListViewState);
        }

        @Override
        public void onSuccess(List<TVEntity> tvEntities) {
            TVMapper tvMapper = new TVMapperImpl();
            tvListViewState.setNetworkState(NetworkState.LOADED);
            tvListViewState.setTvs(tvMapper.mapDomainListToUI(tvEntities));
            tvListViewStateLiveData.postValue(tvListViewState);
        }

        @Override
        public void onError(Throwable e) {
            tvListViewState.setNetworkState(NetworkState.error(e.getMessage()));
            tvListViewStateLiveData.postValue(tvListViewState);
        }
    }
}
