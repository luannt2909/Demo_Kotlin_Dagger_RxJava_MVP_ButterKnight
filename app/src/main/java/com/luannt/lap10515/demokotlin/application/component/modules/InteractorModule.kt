package com.luannt.lap10515.demokotlin.application.component.modules

import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import com.luannt.lap10515.demokotlin.interactor.list.ListFondaInteractor
import com.luannt.lap10515.demokotlin.interactor.list.ListFondaInteractorImpl
import com.luannt.lap10515.demokotlin.interactor.login.LoginInteractor
import com.luannt.lap10515.demokotlin.interactor.login.LoginInteractorImpl
import dagger.Module
import dagger.Provides

/**
 * Created by lap10515 on 04/08/2017.
 */
@Module
class InteractorModule {

    @Provides
    @ControllerScope
    fun provideLoginInteractor(loginInteractor: LoginInteractorImpl): LoginInteractor = loginInteractor

    @Provides
    @ControllerScope
    fun provideListFondaInteractor(listFondaInteractor: ListFondaInteractorImpl): ListFondaInteractor = listFondaInteractor
}
