package com.luannt.lap10515.demokotlin.application.component

import com.luannt.lap10515.demokotlin.application.component.modules.*
import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import com.luannt.lap10515.demokotlin.view.MainActivity
import com.luannt.lap10515.demokotlin.view.list.ListFondaActivity
import com.luannt.lap10515.demokotlin.view.login.LoginActivity
import dagger.Component

/**
 * Created by lap10515 on 03/08/2017.
 */
@ControllerScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(
        ControllerModule::class,
        PresenterModule::class,
        RepositoryModule::class,
        InteractorModule::class,
        RetrofitModule::class,
        ApiModule::class))
interface ControllerComponent : AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(loginActivity: LoginActivity)
    fun inject(listActivity: ListFondaActivity)
}