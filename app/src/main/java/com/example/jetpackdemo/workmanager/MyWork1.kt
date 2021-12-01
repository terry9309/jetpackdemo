package com.example.jetpackdemo.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyWork1(context: Context, workerParameters: WorkerParameters): Worker(context,workerParameters) {


    //后台任务，异步
    override fun doWork(): Result {
        Log.d("Terry", "doWork: start......")

        try {

            Thread.sleep(5000)
        }catch (e:InterruptedException){
            e.printStackTrace()
        }finally {
            Log.d("Terry", "doWork: end......")
        }

        return Result.success()
    }
}
