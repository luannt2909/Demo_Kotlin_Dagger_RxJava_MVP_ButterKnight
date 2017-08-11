package com.luannt.lap10515.demokotlin.interactor.login

import android.util.Log
import com.luannt.lap10515.demokotlin.api.UserApi
import com.luannt.lap10515.demokotlin.api.response.BaseResponse
import com.luannt.lap10515.demokotlin.data.AccessToken
import com.luannt.lap10515.demokotlin.interactor.BaseInteractor
import com.luannt.lap10515.demokotlin.interactor.InteractorCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by lap10515 on 04/08/2017.
 */
open class LoginInteractorImpl : BaseInteractor, LoginInteractor {

    var mUserApi: UserApi



    @Inject constructor(userApi: UserApi) {
        mUserApi = userApi
    }

    override fun login(username: String, password: String, callback: InteractorCallback<AccessToken>) {
        mUserApi.loginUser(username, password)
                .subscribeOn(Schedulers.io())
                .map { t: BaseResponse<AccessToken> ->
                    Log.d("BASERESPONSE", t.data.token)
                    t.data
                }
                //.filter { t: AccessToken -> t != null }
                .observeOn(AndroidSchedulers.mainThread())
                //.doOnNext { t: AccessToken ->  SharedPrefUtil.saveString("token", t.token)}
                .subscribe(
                        Consumer { accessToken -> callback.onSuccess(accessToken) }
                        , Consumer { error -> callback.onError(error) })
    }
}