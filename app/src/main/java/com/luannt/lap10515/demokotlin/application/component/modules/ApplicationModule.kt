package com.luannt.lap10515.demokotlin.application.component.modules

import android.content.Context
import com.luannt.lap10515.demokotlin.application.MainApplication
import com.luannt.lap10515.demokotlin.application.component.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import org.greenrobot.eventbus.EventBus

/**
 * Created by lap10515 on 02/08/2017.
 */
@Module
class ApplicationModule(private val application: MainApplication) {

    val SHARED_PREFERENCE_NAME: String = "SharedPref"

    @Provides
    @ApplicationScope
    fun provideApplicationModule(): MainApplication = application

    @Provides
    @ApplicationScope
    fun provideEventBus(): EventBus = EventBus.getDefault()

    @Provides
    @ApplicationScope
    fun provideSharedPreferences(name: String = SHARED_PREFERENCE_NAME, mode: Int = Context.MODE_PRIVATE) = application.getSharedPreferences(name, mode)
}