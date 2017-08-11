package com.luannt.lap10515.demokotlin.interactor

/**
 * Created by lap10515 on 04/08/2017.
 */

interface InteractorCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Throwable)
}