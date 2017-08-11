package com.luannt.lap10515.demokotlin.view.login

import com.luannt.lap10515.demokotlin.view.base.BaseView

/**
 * Created by lap10515 on 03/08/2017.
 */
interface LoginView : BaseView {
    fun setEnableButtonLogin(isEnable: Boolean)
    fun showHandleLoginError(message: String)
}