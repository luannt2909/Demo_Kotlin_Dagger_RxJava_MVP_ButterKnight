package com.luannt.lap10515.demokotlin.data

import com.google.gson.annotations.SerializedName

/**
 * Created by lap10515 on 01/08/2017.
 */
 data class Fonda(
        var id: Int,
        val name: String,
        val open_time: String,
        val close_time: String,
        val phone_1: String,
        @SerializedName("feature_image")
        val image: Image?) {

}
