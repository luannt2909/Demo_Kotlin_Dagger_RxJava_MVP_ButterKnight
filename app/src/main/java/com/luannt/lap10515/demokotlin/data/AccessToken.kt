package com.luannt.lap10515.demokotlin.data

import com.google.gson.annotations.SerializedName

/**
 * Created by lap10515 on 02/08/2017.
 */
data class AccessToken(
        @SerializedName("id")
        val id: Int,
        @SerializedName("token_string")
        val token: String)