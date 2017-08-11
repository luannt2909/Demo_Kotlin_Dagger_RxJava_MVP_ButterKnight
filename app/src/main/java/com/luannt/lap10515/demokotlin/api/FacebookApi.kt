package com.luannt.lap10515.demokotlin.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by lap10515 on 07/08/2017.
 */
interface FacebookApi {

    @GET("/v2.10/{user_id}/taggable_friends")
    fun getListFriend(@Path("user_id") userId:String,
                      @Query("access_token") token: String,
                      @Query("limit") limit: Int,
                      @Query("after") after: String)
}