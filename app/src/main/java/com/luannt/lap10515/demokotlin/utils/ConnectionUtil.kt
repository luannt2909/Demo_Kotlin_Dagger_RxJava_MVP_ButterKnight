package com.luannt.lap10515.demokotlin.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by lap10515 on 02/08/2017.
 */
object ConnectionUtil {
    fun isAvailableConection(application: Application):Boolean{
        val manager= application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.activeNetworkInfo as NetworkInfo
        return networkInfo.isConnected
    }
}