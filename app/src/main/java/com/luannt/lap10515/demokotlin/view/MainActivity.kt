package com.luannt.lap10515.demokotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.luannt.lap10515.demokotlin.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MainApplication.appComponent.inject(this)
        setContentView(R.layout.activity_main)

    }
}
