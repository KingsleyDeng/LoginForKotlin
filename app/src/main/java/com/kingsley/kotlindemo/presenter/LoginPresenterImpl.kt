package com.kingsley.kotlindemo.presenter

import com.kingsley.kotlindemo.bean.LoginResponse
import com.kingsley.kotlindemo.bean.RegisterResponse
import com.kingsley.kotlindemo.model.LoginModel
import com.kingsley.kotlindemo.model.LoginModelImpl
import com.kingsley.kotlindemo.view.LoginView

/**
 * Created by Kingsley on 2018/1/23.
 */
class LoginPresenterImpl (val loginView: LoginView) : LoginPresenter, LoginPresenter.onLoginListener, LoginPresenter.onRegisterListener {

    val mLoginModel: LoginModel

    init {
        mLoginModel = LoginModelImpl()
    }

    override fun login(username: String, password: String) {
        mLoginModel.login(this, username, password)
    }

    override fun loginSuccess(result: LoginResponse) {
        loginView.loginSuccess(result)
    }

    override fun loginFailed(message: String?) {
        loginView.loginFailed(message)
    }

    override fun register(username: String, password: String, email: String) {
        mLoginModel.register(this, username, password, email)
    }

    override fun registerSuccess(result: RegisterResponse) {
        loginView.registerSuccess(result)
    }

    override fun registerFailed(message: String?) {
        loginView.registerFailed(message)
    }
}