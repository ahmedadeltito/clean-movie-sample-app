package com.ahmedadel.presentation;

import android.content.Context;

import com.ahmedadel.data.DataInjection;
import com.ahmedadel.domain.DomainInjection;
import com.ahmedadel.presentation.viewmodel.home.HomeViewModelFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PresentationInjection {

    public static HomeViewModelFactory provideHomeViewModelFactory(Context context) {
        return new HomeViewModelFactory(Schedulers.io(), AndroidSchedulers.mainThread(),
                DomainInjection.provideMoviesUseCase(DataInjection.provideMovieRepository(context)),
                DomainInjection.providePersonsUseCase(DataInjection.providePersonRepository(context)),
                DomainInjection.provideTVsUseCase(DataInjection.provideTVRepository(context)));
    }

}
