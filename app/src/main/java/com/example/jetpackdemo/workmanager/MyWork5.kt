package com.example.jetpackdemo.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWork5(val context: Context, workerParameters: WorkerParameters):Worker(context,workerParameters) {


    override fun doWork(): Result {

        Log.d("Terry", "doWork:  MyWork5    running ")

        return Result.success()
    }
}