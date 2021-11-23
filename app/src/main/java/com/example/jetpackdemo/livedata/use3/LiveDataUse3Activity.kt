package com.example.jetpackdemo.livedata.use3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackdemo.R

class LiveDataUse3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_use3)

        MyLiveData3.msg.postValue("我已经改变了喔")
        startActivity(Intent(this,LiveDataNextActivity::class.java))
    }
}