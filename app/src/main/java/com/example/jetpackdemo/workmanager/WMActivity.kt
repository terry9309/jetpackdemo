package com.example.jetpackdemo.workmanager


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager

import com.example.jetpackdemo.R
import kotlinx.android.synthetic.main.activity_wm.*
import java.util.concurrent.TimeUnit

class WMActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wm)


        my_worker1.setOnClickListener(this)
        my_worker2.setOnClickListener(this)
        my_worker3.setOnClickListener(this)
        my_worker4.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.my_worker1 -> {

                //单次任务；
                val oneTimeWorkRequest: OneTimeWorkRequest =
                    OneTimeWorkRequest.Builder(MyWork1::class.java).build()
                WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)

            }

            R.id.my_worker2 -> {
                //创建单次任务
                val oneTimeWorkRequest2: OneTimeWorkRequest
                //创建要发送的数据
                val sendData = Data.Builder().putString("Terry", "正在学习WorkManager").build()


                //建造者设计模式
                oneTimeWorkRequest2 =
                    OneTimeWorkRequest.Builder(MyWork2::class.java).setInputData(sendData).build()


                //接受需要用到状态机(liveData)，关联activity 生命周期 只有在页面可见的时候才去接收数据
                WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest2.id)
                    .observe(this, {
                        if (it.state.isFinished) {//判断成功的状态（也就是完成的状态）才能接收到返回的数据

                            Log.d("Terry", "接收到回传的数据：${it.outputData.getString("Terry")}")


                        }
                    }
                    )

                WorkManager.getInstance(this).enqueue(oneTimeWorkRequest2)

            }

            R.id.my_worker3 -> {

                //构建单一任务
                val oneTimeWorkRequest3 = OneTimeWorkRequest.Builder(MyWork3::class.java).build()
                val oneTimeWorkRequest4 = OneTimeWorkRequest.Builder(MyWork4::class.java).build()
                val oneTimeWorkRequest5 = OneTimeWorkRequest.Builder(MyWork5::class.java).build()
                val oneTimeWorkRequest6 = OneTimeWorkRequest.Builder(MyWork6::class.java).build()


                //构建执行顺序 此处直达 MyWork3 执行完成  才执行MyWork4
                /*  WorkManager.getInstance(this)
                      .beginWith(oneTimeWorkRequest3)
                      .then(oneTimeWorkRequest4)
                      .then(oneTimeWorkRequest5)
                      .then(oneTimeWorkRequest6)
                      .enqueue()*/


                //集合写法
                val oneTimeWorkRequests: MutableList<OneTimeWorkRequest> = ArrayList()
                oneTimeWorkRequests.add(oneTimeWorkRequest3)
                oneTimeWorkRequests.add(oneTimeWorkRequest4)
                oneTimeWorkRequests.add(oneTimeWorkRequest5)

                WorkManager.getInstance(this).beginWith(oneTimeWorkRequests)
                    .then(oneTimeWorkRequest6).enqueue()

            }


            R.id.my_worker4 -> {

                //这里虽然设置为10s 执行一次 ，但是Google  为了兼顾耗电，默认循环的最小间隔为15分钟，
                val periodicWorkRequest =
                    PeriodicWorkRequest.Builder(MyWork3::class.java, 10, TimeUnit.SECONDS).build()

                WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id)
                    .observe(this,{

                        if (it.state.isFinished) {
                            Log.d("Terry", "状态：MyWork3:后台任务已经完成了...")
                        }
                    })


                WorkManager.getInstance(this).enqueue(periodicWorkRequest)
            }
        }
    }
}