package com.example.jetpackdemo.dataBinding

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class Student :BaseObservable() {



    //Kotlin 内部自动生成Get() set()
    val nameF:ObservableField<String>  by lazy { ObservableField<String>() }

    val ageF:ObservableField<Int>  by lazy { ObservableField<Int>() }


}