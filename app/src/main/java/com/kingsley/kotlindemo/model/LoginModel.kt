package com.kingsley.kotlindemo.model

import com.kingsley.kotlindemo.presenter.LoginPresenter

/**
 * Created by Kingsley on 2018/1/23.
 */
interface LoginModel {

    /**
     * 登录
     */
    fun login(onLoginListener: LoginPresenter.onLoginListener, username: String, password: String)

    /**
     * 注册
     */
    fun register(onRegisterListener: LoginPresenter.onRegisterListener, username: String, password: String, email: String)
}