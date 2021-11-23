package com.example.jetpackdemo.livedata.use2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.jetpackdemo.livedata.use1.MyLiveData
import kotlin.concurrent.thread

class MyService :Service() {



    override fun onBind(intent: Intent?): IBinder?  = null


    /**
     *  服务默认是在主线程
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        thread {

            for (x in 1..1000){

                Log.w("MyService","服务器推送消息了：消息内容是：${x}")

                MyLiveData2.msg.postValue("服务器推送消息了：消息内容是：${x}")

                Thread.sleep(3000)
            }

        }


        return super.onStartCommand(intent, flags, startId)
    }
}