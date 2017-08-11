package com.luannt.lap10515.demokotlin.utils

import java.util.regex.Pattern

/**
 * Created by lap10515 on 04/08/2017.
 */
object RegexUtil{

    val USERNAME_PATERN: Pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$")
    val PASSWORD_PATERN: Pattern = Pattern.compile("^[a-zA-Z0-9_-]{6,18}$")

    fun isValidUsername(username:String):Boolean = USERNAME_PATERN.matcher(username).matches()

    fun isValidPassword(password: String): Boolean = PASSWORD_PATERN.matcher(password).matches()
}