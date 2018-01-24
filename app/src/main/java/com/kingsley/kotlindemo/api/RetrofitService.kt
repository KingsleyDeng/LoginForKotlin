package com.kingsley.kotlindemo.api

import com.kingsley.kotlindemo.bean.LoginResponse
import com.kingsley.kotlindemo.bean.RegisterResponse
import com.kingsley.kotlindemo.constant.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kingsley on 2018/1/24.
 */
interface RetrofitService {

    /**
     * 注册
     * key 用户申请的appkey
     * username 用户名（一个key只能存在唯一username）
     * password 用户密码（建议加密）
     * email 邮箱
     */
    @GET("rigister")
    fun userRegister(@Query("username") username: String,
                     @Query("password") password: String,
                     @Query("email") email: String,
                     @Query("key") key: String = Constant.KEY
    ): Observable<RegisterResponse>

    /**
     * 登录
     * key 用户申请的appkey
     * username 用户名
     * password 用户密码
     */
    @GET("login")
    fun userLogin(
            @Query("username") username: String,
            @Query("password") password: String,
            @Query("key") key: String = Constant.KEY
    ): Observable<LoginResponse>
}