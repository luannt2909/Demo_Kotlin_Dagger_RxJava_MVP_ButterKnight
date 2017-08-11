package com.luannt.lap10515.demokotlin.interactor.login

import com.luannt.lap10515.demokotlin.data.AccessToken
import com.luannt.lap10515.demokotlin.interactor.Interactor
import com.luannt.lap10515.demokotlin.interactor.InteractorCallback

/**
 * Created by lap10515 on 04/08/2017.
 */
interface LoginInteractor: Interactor{
    fun login(username: String, password: String, callback: InteractorCallback<AccessToken>)
}