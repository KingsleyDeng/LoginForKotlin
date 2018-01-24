package com.kingsley.kotlindemo.model

import com.kingsley.kotlindemo.presenter.LoginPresenter
import com.kingsley.kotlindemo.utils.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Kingsley on 2018/1/23.
 */
class LoginModelImpl : LoginModel {

    var mOnLoginListener: LoginPresenter.onLoginListener? = null
    var mOnRegisterListener: LoginPresenter.onRegisterListener? = null

    override fun login(onLoginListener: LoginPresenter.onLoginListener, username: String, password: String) {
        if (mOnLoginListener == null) {
            mOnLoginListener = onLoginListener
        }
        RetrofitUtils
                .retrofitService
                .userLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            when (result.retCode) {
                                "200" ->
                                    mOnLoginListener?.loginSuccess(result)
                                else ->
                                    mOnLoginListener?.loginFailed(result.msg)
                            }
                        },
                        {
                            error ->
                            mOnLoginListener?.loginFailed(error.message)
                        })
    }


    override fun register(onRegisterListener: LoginPresenter.onRegisterListener, username: String, password: String, email: String) {
        if (mOnRegisterListener == null) {
            mOnRegisterListener = onRegisterListener
        }
        RetrofitUtils
                .retrofitService
                .userRegister(username, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->
                            when (result.retCode) {
                                "200" ->
                                    mOnRegisterListener?.registerSuccess(result)
                                else ->
                                    mOnRegisterListener?.registerFailed(result.msg)
                            }
                        },
                        {
                            error ->
                            mOnRegisterListener?.registerFailed(error.message)
                        })
    }
}

