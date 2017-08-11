package com.luannt.lap10515.demokotlin.application.component.modules

/**
 * Created by lap10515 on 08/08/2017.
 */
/*
@Module
class RealmModule {
    var mApplicationContext: Context
    constructor(application: Context){
        mApplicationContext = application
        initRealm()
    }

    @Provides
    @ApplicationScope
    fun provideRealm(): Realm = Realm.getDefaultInstance()

    private fun initRealm() {
        var realmConfiguration: RealmConfiguration =RealmConfiguration.Builder(mApplicationContext)
                .rxFactory(RealmObservableFactory())
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

}*/
