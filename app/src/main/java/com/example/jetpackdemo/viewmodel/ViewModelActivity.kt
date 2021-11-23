package com.example.jetpackdemo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackdemo.R

import com.example.jetpackdemo.databinding.ActivityViewModelBinding


class ViewModelActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var binding = DataBindingUtil.setContentView<ActivityViewModelBinding>(this, R.layout.activity_view_model)





        val viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application))
            .get(MainViewModel::class.java)

        binding.vm = viewModel

        //建立感应关系
        binding.lifecycleOwner = this

    }
}