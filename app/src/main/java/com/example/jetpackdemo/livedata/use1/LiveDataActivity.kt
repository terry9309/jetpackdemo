package com.example.jetpackdemo.livedata.use1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_live_data.*
import kotlin.concurrent.thread


class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)




        MyLiveData.info1.observe(this,
            Observer<String> {

                tv_start.text = it

            })


        MyLiveData.info1.value = "default"

        thread {

            Thread.sleep(3000)
            MyLiveData.info1.postValue("睡了3秒钟")
        }

        thread {
            Thread.sleep(6000)
            MyLiveData.info1.postValue("睡了6秒钟")
        }


    }

}