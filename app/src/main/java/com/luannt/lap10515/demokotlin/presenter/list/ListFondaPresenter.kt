package com.luannt.lap10515.demokotlin.presenter.list

import com.luannt.lap10515.demokotlin.presenter.base.Presenter
import com.luannt.lap10515.demokotlin.view.list.ListFondaNavigator
import com.luannt.lap10515.demokotlin.view.list.ListFondaView

/**
 * Created by lap10515 on 04/08/2017.
 */
interface ListFondaPresenter: Presenter<ListFondaView, ListFondaNavigator> {

    fun getListFonda(page: Int)
}