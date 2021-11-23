package com.example.jetpackdemo.livedata.use2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_live_data_use2.*

class LiveDataUse2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_use2)

        button.setOnClickListener {
            startService(Intent(this,MyService::class.java))
            Toast.makeText(this,"服务启动成功",Toast.LENGTH_SHORT).show()


        }
        MyLiveData2.msg.observe(this,object :Observer<String>{
            override fun onChanged(t: String?) {
                Log.e("MyService","界面可见，说明用户在查看消息界面，更新消息列表UI界面：${t}")

             //   Toast.makeText(this,"",Toast.LENGTH_SHORT).show()

            }
        })
    }
}