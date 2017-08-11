package com.luannt.lap10515.demokotlin.presenter.base

import com.luannt.lap10515.demokotlin.view.base.BaseView
import com.luannt.lap10515.demokotlin.view.base.Navigator

/**
 * Created by lap10515 on 03/08/2017.
 */
open class BasePresenter<V : BaseView, N : Navigator>() : Presenter<V, N> {

    protected var mView: V? = null
    protected var mNavigator: N? = null

    override fun setView(view: V) {
        mView = view
    }

    override fun getView(): V? = mView

    override fun setNavigator(navigator: N) {
        mNavigator = navigator
    }

    override fun getNavigator(): N? = mNavigator

}