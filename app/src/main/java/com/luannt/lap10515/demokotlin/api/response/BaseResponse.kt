package com.luannt.lap10515.demokotlin.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by lap10515 on 02/08/2017.
 */
data class BaseResponse<T>(
        @SerializedName("data")
        val data: T
)