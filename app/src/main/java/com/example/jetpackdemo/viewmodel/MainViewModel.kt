package com.example.jetpackdemo.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData



//AndroidViewModel 与 ViewModel 的区别是 AndroidViewModel 需要传入环境
class MainViewModel(application:Application):AndroidViewModel(application) {



    public val phoneInfo by lazy { MutableLiveData<String>() }

    var context: Context = application

    //初始化phoneInfo
    init {
        phoneInfo.value = "";
    }


    /**
     *  增加
     */
    public fun appendNum(num:String){
        phoneInfo.value = phoneInfo.value+num;

    }

    /**
     *  删除
     */

    public fun delNum(){
        var len = phoneInfo.value?.length?:0
        if (len>0){
            phoneInfo.value = phoneInfo.value?.substring(0,len-1)
        }
    }



}