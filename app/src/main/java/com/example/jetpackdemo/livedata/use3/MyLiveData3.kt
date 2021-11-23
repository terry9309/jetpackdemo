package com.example.jetpackdemo.livedata.use3

import androidx.lifecycle.MutableLiveData

object MyLiveData3 {

    val msg:MutableLiveData<String> by lazy { MutableLiveData<String>() }

}