package com.example.jetpackdemo.livedata.use3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpackdemo.R

class LiveDataNextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_next)


        MyLiveData3.msg.observe(this,

            Observer<String> { Toast.makeText(this@LiveDataNextActivity,"数据变化：${it}",Toast.LENGTH_SHORT).show() })
    }
}