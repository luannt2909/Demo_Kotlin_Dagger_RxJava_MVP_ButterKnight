package com.luannt.lap10515.demokotlin.api.response

/**
 * Created by lap10515 on 02/08/2017.
 */
data class Paging<T>(
        val total: Int,
        val per_page: Int,
        val current_page: Int,
        val last_page: Int,
        val from: Int,
        val to: Int,
        val data: List<T>?
)