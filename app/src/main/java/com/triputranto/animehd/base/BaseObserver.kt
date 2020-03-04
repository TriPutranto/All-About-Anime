package com.triputranto.animehd.base

import io.reactivex.observers.DisposableSingleObserver

abstract class BaseObserver<T> : DisposableSingleObserver<T>() {
    override fun onSuccess(entity: T) {}

    override fun onError(e: Throwable) {}
}