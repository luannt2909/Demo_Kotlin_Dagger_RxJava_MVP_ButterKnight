package com.luannt.lap10515.demokotlin.api

import com.luannt.lap10515.demokotlin.api.response.BaseResponse
import com.luannt.lap10515.demokotlin.api.response.Paging
import com.luannt.lap10515.demokotlin.data.Fonda
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Created by lap10515 on 02/08/2017.
 */
interface FondaApi {
    @GET("/fonda")
    fun getListFonda(@QueryMap queryMap: Map<String, Int>): Observable<BaseResponse<Paging<Fonda>>>

    @GET("/fonda/{id}")
    fun getDetailFonda(@Path("id") id: Int): Observable<BaseResponse<Fonda>>
}