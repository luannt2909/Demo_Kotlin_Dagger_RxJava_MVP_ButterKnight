package com.luannt.lap10515.demokotlin.application.component.modules

import android.app.Activity
import android.content.Context
import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import com.luannt.lap10515.demokotlin.view.list.FondaAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by lap10515 on 08/08/2017.
 */
@Module
@ControllerScope
class ControllerModule {
    var mActivity: Activity

    constructor(activity: Activity){
        mActivity = activity
    }

    @Provides
    @ControllerScope
    fun provideControllerContext(): Context = mActivity

    @Provides
    @ControllerScope
    fun provideControllerActivity(): Activity = mActivity

    @Provides
    @ControllerScope
    fun provideFondaAdapter(): FondaAdapter = FondaAdapter(mActivity)
}