package com.luannt.lap10515.demokotlin.view.login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.luannt.lap10515.demokotlin.R
import com.luannt.lap10515.demokotlin.application.component.ControllerComponent
import com.luannt.lap10515.demokotlin.presenter.login.LoginPresenter
import com.luannt.lap10515.demokotlin.view.base.BaseActivity
import com.luannt.lap10515.demokotlin.view.list.ListFondaActivity

/**
 * Created by lap10515 on 03/08/2017.
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView, LoginNavigator {


    @BindView(R.id.edt_username)
    lateinit var mEdt_username: TextInputEditText

    @BindView(R.id.edt_password)
    lateinit var mEdt_password: TextInputEditText

    @BindView(R.id.btn_login)
    lateinit var mBtn_login: Button

    @BindView(R.id.tv_invalid_input)
    lateinit var mTv_invalid_input: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.setView(this)
        mPresenter.setNavigator(this)
        initView()
        //mPresenter.checkLoginStatus()

    }

    private fun initView() {
        mEdt_username.addTextChangedListener(inputTextWatcher)
        mEdt_password.addTextChangedListener(inputTextWatcher)
    }

    @OnClick(R.id.btn_login)
    fun onClickBtnLogin() {
        mPresenter.login(mEdt_username.text.toString(), mEdt_password.text.toString())
    }

    // Excute text change of username
    var inputTextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            mPresenter.checkInputValid(mEdt_username.text.toString(), mEdt_password.text.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    override fun setEnableButtonLogin(isEnable: Boolean) {
        mBtn_login.isEnabled = isEnable
        mTv_invalid_input.visibility = View.GONE
    }

    override fun showHandleLoginError(message: String) {
        mTv_invalid_input.visibility = View.VISIBLE
        mTv_invalid_input.text = message
    }

    override fun goToHome() {
        startActivity(Intent(this, ListFondaActivity::class.java))
    }

    override fun inject(controlComponent: ControllerComponent) {
        controllerComponent.inject(this)
    }

    override fun getLayoutId(): Int = R.layout.activity_login
}