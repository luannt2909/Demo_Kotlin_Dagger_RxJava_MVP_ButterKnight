package com.luannt.lap10515.demokotlin.presenter.list

import android.util.Log
import com.luannt.lap10515.demokotlin.api.response.Paging
import com.luannt.lap10515.demokotlin.data.Fonda
import com.luannt.lap10515.demokotlin.interactor.InteractorCallback
import com.luannt.lap10515.demokotlin.interactor.list.ListFondaInteractor
import com.luannt.lap10515.demokotlin.presenter.base.BasePresenter
import com.luannt.lap10515.demokotlin.view.list.ListFondaNavigator
import com.luannt.lap10515.demokotlin.view.list.ListFondaView
import javax.inject.Inject

/**
 * Created by lap10515 on 04/08/2017.
 */
class ListFondaPresenterImpl : BasePresenter<ListFondaView, ListFondaNavigator>, ListFondaPresenter {

    var mInteractor: ListFondaInteractor

    @Inject constructor(interactor: ListFondaInteractor) {
        mInteractor = interactor
    }

    override fun getListFonda(page: Int) {
        mInteractor.getListFonda(page, object: InteractorCallback<Paging<Fonda>>{
            override fun onSuccess(data: Paging<Fonda>) {
                mView?.showList(data)
            }

            override fun onError(error: Throwable) {
                Log.e("Error", "Error while loading data")
            }
        })
    }
}