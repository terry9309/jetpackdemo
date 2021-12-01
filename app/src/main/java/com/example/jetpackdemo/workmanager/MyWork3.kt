package com.example.jetpackdemo.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork3(val context: Context,workerParameters: WorkerParameters):Worker(context,workerParameters) {


    override fun doWork(): Result {

        Log.d("Terry", "doWork:  MyWork3    running ")
        try {

            Thread.sleep(5000)
        }catch (e:InterruptedException){
            e.printStackTrace()
        }finally {
            Log.d("Terry", "doWork: MyWork3  end......")
        }

        return Result.success()
    }
}