package com.luannt.lap10515.demokotlin.interactor.list

import com.luannt.lap10515.demokotlin.api.FondaApi
import com.luannt.lap10515.demokotlin.api.response.Paging
import com.luannt.lap10515.demokotlin.data.Fonda
import com.luannt.lap10515.demokotlin.interactor.BaseInteractor
import com.luannt.lap10515.demokotlin.interactor.InteractorCallback
import com.luannt.lap10515.demokotlin.utils.SharedPrefUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by lap10515 on 07/08/2017.
 */
class ListFondaInteractorImpl: BaseInteractor, ListFondaInteractor {
    var mFondaApi: FondaApi

    @Inject constructor(fondaApi: FondaApi){
        mFondaApi = fondaApi
    }

    override fun getListFonda(page: Int, callback: InteractorCallback<Paging<Fonda>>) {
        var map:Map<String, Int> = hashMapOf("page" to page)
        mFondaApi.getListFonda(map)
                .subscribeOn(Schedulers.io())
                .map { res->res.data }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { data -> callback.onSuccess(data) }
                , Consumer { error-> callback.onError(error) })

    }
}