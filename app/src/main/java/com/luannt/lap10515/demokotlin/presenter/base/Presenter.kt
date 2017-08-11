package com.luannt.lap10515.demokotlin.presenter.base

/**
 * Created by lap10515 on 03/08/2017.
 */
interface Presenter<V, N> {
    fun setView(view: V)

    fun getView(): V?

    fun setNavigator(navigator: N)

    fun getNavigator(): N?

}