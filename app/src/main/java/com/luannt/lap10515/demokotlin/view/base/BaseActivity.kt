package com.luannt.lap10515.demokotlin.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import com.luannt.lap10515.demokotlin.application.MainApplication
import com.luannt.lap10515.demokotlin.application.component.ControllerComponent
import com.luannt.lap10515.demokotlin.application.component.DaggerControllerComponent
import com.luannt.lap10515.demokotlin.application.component.modules.*
import com.luannt.lap10515.demokotlin.application.component.scopes.ControllerScope
import com.luannt.lap10515.demokotlin.presenter.base.Presenter
import javax.inject.Inject


/**
 * Created by lap10515 on 03/08/2017.
 */
@ControllerScope
open abstract class BaseActivity<P: Presenter<*,*>> : AppCompatActivity(), BaseView, Navigator {

    @Inject lateinit var  mPresenter: P
    //@Inject lateinit var mPresenter: LoginPresenter

    var mUnbinder: Unbinder? =null


    val controllerComponent: ControllerComponent by lazy {
        DaggerControllerComponent
                .builder()
                .controllerModule(ControllerModule(this))
                .presenterModule(PresenterModule())
                .repositoryModule(RepositoryModule())
                .retrofitModule(RetrofitModule())
                .apiModule(ApiModule())
                .appComponent(MainApplication.appComponent)
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        inject(controllerComponent)
        mUnbinder= ButterKnife.bind(this)
    }

    override fun onStop() {
        super.onStop()
        mUnbinder?.unbind()
    }

    abstract fun getLayoutId():Int
    abstract fun inject(controllerComponent: ControllerComponent)

}


