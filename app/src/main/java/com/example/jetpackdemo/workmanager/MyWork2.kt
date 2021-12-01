package com.example.jetpackdemo.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork2(val context: Context,val workerParameters: WorkerParameters):Worker(context,workerParameters) {




    override fun doWork(): Result {

        Log.d("Terry", "doWork:MyWorker2 start .... ")

        val  dataString = workerParameters.inputData.getString("Terry")


        Log.d("Terry", "doWork:MyWorker2 接受到传递过来的数据：${dataString} ")

        //回传数据到VMActivity
        val  returnString  = Data.Builder().putString("Terry","$dataString,学会了").build()

        return Result.success(returnString)


    }


}