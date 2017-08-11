package com.luannt.lap10515.demokotlin.utils

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by lap10515 on 04/08/2017.
 */
/*
open class SharedPrefUtil {
    @Inject lateinit var mSharedPref: SharedPreferences

    lateinit var mEditor: SharedPreferences.Editor

    fun saveString(key: String, value: String) {
        mSharedPref.edit().putString(key,value).apply()
        //mEditor.putString(key, value)
        //mEditor.commit()
    }

    fun loadString(key: String, defaultValue: String) = mSharedPref.getString(key, defaultValue)
}*/
class SharedPrefUtil{
    @Inject lateinit var mSharedPref: SharedPreferences

    fun saveString(key: String, value: String) {
        mSharedPref.edit().putString(key,value).apply()
    }

    fun loadString(key: String, defaultValue: String) = mSharedPref.getString(key, defaultValue)
}