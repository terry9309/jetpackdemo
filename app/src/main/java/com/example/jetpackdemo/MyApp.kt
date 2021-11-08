package com.example.jetpackdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//Hilt:step 3
@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}