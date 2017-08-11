package com.luannt.lap10515.demokotlin.application.component.modules

import com.luannt.lap10515.demokotlin.api.FondaApi
import com.luannt.lap10515.demokotlin.api.UserApi
import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by lap10515 on 02/08/2017.
 */
@Module
class ApiModule() {

    @Provides
    @ControllerScope
    fun provideUserApiModule(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    @ControllerScope
    fun provideFondaApiModule(retrofit: Retrofit): FondaApi = retrofit.create(FondaApi::class.java)

}