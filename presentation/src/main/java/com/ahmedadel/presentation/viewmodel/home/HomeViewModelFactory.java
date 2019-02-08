package com.ahmedadel.presentation.viewmodel.home;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.ahmedadel.domain.usecase.movie.GetMoviesUseCase;
import com.ahmedadel.domain.usecase.person.GetPersonsUseCase;
import com.ahmedadel.domain.usecase.tv.GetTVsUseCase;

import io.reactivex.Scheduler;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private Scheduler subscribeOn;
    private Scheduler observeOn;
    private GetMoviesUseCase getMoviesUseCase;
    private GetPersonsUseCase getPersonsUseCase;
    private GetTVsUseCase getTVsUseCase;

    public HomeViewModelFactory(Scheduler subscribeOn, Scheduler observeOn,
                                GetMoviesUseCase getMoviesUseCase, GetPersonsUseCase getPersonsUseCase,
                                GetTVsUseCase getTVsUseCase) {
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
        this.getMoviesUseCase = getMoviesUseCase;
        this.getPersonsUseCase = getPersonsUseCase;
        this.getTVsUseCase = getTVsUseCase;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class))
            return (T) new HomeViewModel(subscribeOn, observeOn,
                    getMoviesUseCase, getPersonsUseCase, getTVsUseCase);
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
