package com.example.jetpackdemo.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpackdemo.R


class DataBindUseActivity : AppCompatActivity() {

    var mStudent:Student = Student()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<com.example.jetpackdemo.databinding.ActivityDataBindUseBinding>(this,R.layout.activity_data_bind_use)



        mStudent.nameF.set("terry")
        mStudent.ageF.set(12)
        binding.student = mStudent





    }
}