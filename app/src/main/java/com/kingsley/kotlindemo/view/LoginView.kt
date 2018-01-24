package com.kingsley.kotlindemo.view

import com.kingsley.kotlindemo.bean.LoginResponse
import com.kingsley.kotlindemo.bean.RegisterResponse

/**
 * Created by Kingsley on 2018/1/23.
 */
interface  LoginView {

    /**
     * 登录成功
     */
    fun loginSuccess(result: LoginResponse)

    /**
     * 登录失败
     */
    fun loginFailed(message: String?)

    /**
     * 注册成功
     */
    fun registerSuccess(result: RegisterResponse)

    /**
     * 注册失败
     */
    fun registerFailed(message: String?)

}