package com.ahmedadel.presentation.viewmodel;


import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.support.v4.util.Preconditions;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public class BaseViewModel extends ViewModel {

    private final Scheduler subscribeOn;
    private final Scheduler observeOn;
    private final CompositeDisposable disposables;

    public BaseViewModel(Scheduler subscribeOn, Scheduler observeOn) {
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
        this.disposables = new CompositeDisposable();
    }

    @SuppressLint("RestrictedApi")
    public <T> void execute(DisposableSingleObserver<T> observer, Single<T> useCase) {
        Preconditions.checkNotNull(observer);
        final Single<T> observable = useCase
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
        addDisposable(observable.subscribeWith(observer));
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    @SuppressLint("RestrictedApi")
    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        dispose();
    }
}
