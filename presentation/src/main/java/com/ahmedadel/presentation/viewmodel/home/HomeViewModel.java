package com.ahmedadel.presentation.viewmodel.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

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
        MovieListViewState movieListViewState = new MovieListViewState();
        execute(
                subscription -> {
                    movieListViewState.setNetworkState(NetworkState.LOADING);
                    movieViewStateLiveData.postValue(movieListViewState);
                },
                movieEntities -> {
                    MovieMapper movieMapper = new MovieMapperImpl();
                    movieListViewState.setNetworkState(NetworkState.LOADED);
                    movieListViewState.setMovies(movieMapper.mapDomainListToUI(movieEntities));
                    movieViewStateLiveData.postValue(movieListViewState);
                },
                throwable -> {
                    movieListViewState.setNetworkState(NetworkState.error(throwable.getMessage()));
                    movieViewStateLiveData.postValue(movieListViewState);
                },
                getMoviesUseCase.getMovies(1)
        );
    }

    public void callPersons() {
        PersonListViewState personListViewState = new PersonListViewState();
        execute(
                subscription -> {
                    personListViewState.setNetworkState(NetworkState.LOADING);
                    personLViewStateLiveData.postValue(personListViewState);
                },
                personEntities -> {
                    PersonMapper personMapper = new PersonMapperImpl();
                    personListViewState.setNetworkState(NetworkState.LOADED);
                    personListViewState.setPersons(personMapper.mapDomainListToUI(personEntities));
                    personLViewStateLiveData.postValue(personListViewState);
                },
                throwable -> {
                    personListViewState.setNetworkState(NetworkState.error(throwable.getMessage()));
                    personLViewStateLiveData.postValue(personListViewState);
                },
                getPersonsUseCase.getPersons(1));
    }

    public void callTVs() {
        TVListViewState tvListViewState = new TVListViewState();
        execute(
                subscription -> {
                    tvListViewState.setNetworkState(NetworkState.LOADING);
                    tvListViewStateLiveData.postValue(tvListViewState);
                },
                tvEntities -> {
                    TVMapper tvMapper = new TVMapperImpl();
                    tvListViewState.setNetworkState(NetworkState.LOADED);
                    tvListViewState.setTvs(tvMapper.mapDomainListToUI(tvEntities));
                    tvListViewStateLiveData.postValue(tvListViewState);
                },
                throwable -> {
                    tvListViewState.setNetworkState(NetworkState.error(throwable.getMessage()));
                    tvListViewStateLiveData.postValue(tvListViewState);
                },
                getTVsUseCase.getTVs(1));
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
}
