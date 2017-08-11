package com.luannt.lap10515.demokotlin.api

import com.luannt.lap10515.demokotlin.api.response.BaseResponse
import com.luannt.lap10515.demokotlin.data.AccessToken
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Created by lap10515 on 02/08/2017.
 */
interface UserApi {
    @FormUrlEncoded
    @POST("/login")
    fun loginUser(@Field("username") username: String, @Field("password") password: String): Observable<BaseResponse<AccessToken>>
}