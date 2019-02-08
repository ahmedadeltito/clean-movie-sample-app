package com.ahmedadel.presentation.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.support.v4.util.Preconditions;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

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
    protected <T> void execute(Consumer<Subscription> loadingConsumer, Consumer<T> successConsumer, Consumer<Throwable> throwableConsumer, Flowable<T> useCase) {
        Preconditions.checkNotNull(successConsumer);
        Preconditions.checkNotNull(throwableConsumer);
        final Flowable<T> observable = useCase
                .doOnSubscribe(loadingConsumer)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn);
        addDisposable(observable.subscribe(successConsumer, throwableConsumer));
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
