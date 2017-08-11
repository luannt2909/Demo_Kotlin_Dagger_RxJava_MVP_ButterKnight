package com.luannt.lap10515.demokotlin.presenter.login

import com.luannt.lap10515.demokotlin.data.AccessToken
import com.luannt.lap10515.demokotlin.interactor.InteractorCallback
import com.luannt.lap10515.demokotlin.interactor.login.LoginInteractor
import com.luannt.lap10515.demokotlin.presenter.base.BasePresenter
import com.luannt.lap10515.demokotlin.utils.RegexUtil
import com.luannt.lap10515.demokotlin.view.login.LoginNavigator
import com.luannt.lap10515.demokotlin.view.login.LoginView
import javax.inject.Inject

/**
 * Created by lap10515 on 03/08/2017.
 */
class LoginPresenterImpl : BasePresenter<LoginView, LoginNavigator>, LoginPresenter {

    private val mInteractor: LoginInteractor

    @Inject constructor(loginInteractor: LoginInteractor) {
        mInteractor = loginInteractor
    }

    override fun checkLoginStatus() {
        //var token = SharedPrefUtil.loadString("token", "")
        //if (token.isNotEmpty())
        //    mNavigator?.goToHome()
    }

    override fun login(username: String, password: String) {
        mInteractor.login(username, password, object : InteractorCallback<AccessToken> {
            override fun onSuccess(data: AccessToken) {
                mNavigator?.goToHome()
            }

            override fun onError(error: Throwable) {
                mView?.showHandleLoginError(error.toString() ?: "")
            }

        })
    }

    override fun checkInputValid(username: String, password: String) {
        if (!RegexUtil.isValidUsername(username)) {
            mView?.setEnableButtonLogin(false)
            mView?.showHandleLoginError("username invalid")
            return
        }
        if (!RegexUtil.isValidPassword(password)) {
            mView?.setEnableButtonLogin(false)
            mView?.showHandleLoginError("password invalid")
            return
        }
        mView?.setEnableButtonLogin(true)
    }

}