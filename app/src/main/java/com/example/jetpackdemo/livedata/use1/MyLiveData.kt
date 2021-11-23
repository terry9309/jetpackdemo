package com.example.jetpackdemo.livedata.use1

import androidx.lifecycle.MutableLiveData

object MyLiveData { //此处为单例模式

    val info1: MutableLiveData<String>  by lazy { MutableLiveData<String>() }

}