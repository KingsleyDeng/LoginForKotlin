package com.kingsley.kotlindemo.presenter

import com.kingsley.kotlindemo.bean.LoginResponse
import com.kingsley.kotlindemo.bean.RegisterResponse

/**
 * Created by Kingsley on 2018/1/23.
 */
interface LoginPresenter {

    /**
     * 登录
     */
    fun login(username: String, password: String)

    /**
     * 登录接口
     */
    interface onLoginListener {
        /**
         * 登录成功
         */
        fun loginSuccess(result: LoginResponse)

        /**
         * 登录失败
         */
        fun loginFailed(message: String?)
    }

    /**
     * 注册
     */
    fun register(username: String, password: String, email: String)

    /**
     * 注册接口
     */
    interface onRegisterListener {
        /**
         * 注册成功
         */
        fun registerSuccess(result: RegisterResponse)

        /**
         * 注册失败
         */
        fun registerFailed(message: String?)
    }

}