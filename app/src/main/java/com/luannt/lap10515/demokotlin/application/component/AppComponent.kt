package com.luannt.lap10515.demokotlin.application.component

import com.luannt.lap10515.demokotlin.application.MainApplication
import com.luannt.lap10515.demokotlin.application.component.modules.ApplicationModule
import com.luannt.lap10515.demokotlin.application.component.scopes.ApplicationScope
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lap10515 on 02/08/2017.
 */
@Singleton
@ApplicationScope
@Component(modules = arrayOf(
        ApplicationModule::class))
interface AppComponent {
    fun inject(mainApplication: MainApplication)

}