package com.ahmedadel.presentation.viewmodel;

import io.reactivex.observers.DisposableSingleObserver;

public class DefaultSingle<T> extends DisposableSingleObserver<T> {

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }
}
