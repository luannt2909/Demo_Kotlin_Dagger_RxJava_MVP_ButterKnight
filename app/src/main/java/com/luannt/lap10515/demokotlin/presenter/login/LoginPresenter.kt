package com.luannt.lap10515.demokotlin.presenter.login

import com.luannt.lap10515.demokotlin.presenter.base.Presenter
import com.luannt.lap10515.demokotlin.view.login.LoginNavigator
import com.luannt.lap10515.demokotlin.view.login.LoginView

/**
 * Created by lap10515 on 03/08/2017.
 */
interface LoginPresenter:Presenter<LoginView,LoginNavigator>{
    fun checkLoginStatus()
    fun login(username: String, password: String)
    fun checkInputValid(username: String, password: String)
}