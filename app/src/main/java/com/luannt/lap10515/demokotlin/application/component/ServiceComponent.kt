package com.luannt.lap10515.demokotlin.application.component

import com.luannt.lap10515.demokotlin.application.component.modules.RepositoryModule
import com.luannt.lap10515.demokotlin.application.component.scopes.ServiceScope
import dagger.Component

/**
 * Created by lap10515 on 03/08/2017.
 */
@ServiceScope
@Component(modules = arrayOf(
        RepositoryModule::class),
        dependencies = arrayOf(AppComponent::class))
interface ServiceComponent{

}