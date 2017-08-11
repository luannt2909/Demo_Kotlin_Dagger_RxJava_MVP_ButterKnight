package com.luannt.lap10515.demokotlin.application.component.modules

import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import com.luannt.lap10515.demokotlin.presenter.list.ListFondaPresenter
import com.luannt.lap10515.demokotlin.presenter.list.ListFondaPresenterImpl
import com.luannt.lap10515.demokotlin.presenter.login.LoginPresenter
import com.luannt.lap10515.demokotlin.presenter.login.LoginPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by lap10515 on 02/08/2017.
 */
@Module
class PresenterModule {
    @Provides
    @ControllerScope
    fun provideLoginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter = loginPresenter

    @Provides
    @ControllerScope
    fun provideListFondaPresenter(listFondaPresenter: ListFondaPresenterImpl): ListFondaPresenter = listFondaPresenter
}