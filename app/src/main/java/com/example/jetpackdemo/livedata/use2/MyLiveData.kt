package com.example.jetpackdemo.livedata.use2

import androidx.lifecycle.MutableLiveData

object MyLiveData2 {



    val msg: MutableLiveData<String> by lazy { MutableLiveData<String>() }


}