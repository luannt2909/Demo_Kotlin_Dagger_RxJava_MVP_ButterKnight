package com.luannt.lap10515.demokotlin.application

import android.app.Application
import com.luannt.lap10515.demokotlin.application.component.AppComponent
import com.luannt.lap10515.demokotlin.application.component.DaggerAppComponent
import com.luannt.lap10515.demokotlin.application.component.modules.ApplicationModule
import com.luannt.lap10515.demokotlin.application.component.scopes.ApplicationScope
import com.squareup.leakcanary.LeakCanary

/**
 * Created by lap10515 on 01/08/2017.
 */
@ApplicationScope
class MainApplication: Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        appComponent.inject(this)
        LeakCanary.install(this)

    }


}