package com.luannt.lap10515.demokotlin.interactor.list

import com.luannt.lap10515.demokotlin.api.response.Paging
import com.luannt.lap10515.demokotlin.data.Fonda
import com.luannt.lap10515.demokotlin.interactor.Interactor
import com.luannt.lap10515.demokotlin.interactor.InteractorCallback

/**
 * Created by lap10515 on 07/08/2017.
 */
interface ListFondaInteractor: Interactor {
    fun getListFonda(page:Int, interactorCallback: InteractorCallback<Paging<Fonda>>)
}