package com.example.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jetpackdemo.dataBinding.DataBindUseActivity
import com.example.jetpackdemo.hilt.HiltActivity
import com.example.jetpackdemo.livedata.use1.LiveDataActivity
import com.example.jetpackdemo.livedata.use2.LiveDataUse2Activity
import com.example.jetpackdemo.livedata.use3.LiveDataUse3Activity
import com.example.jetpackdemo.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HiltUse.setOnClickListener(this)
        LiveDataUse.setOnClickListener(this)
        DataBindingUse.setOnClickListener(this)
        ViewModelUse.setOnClickListener(this)
    }

    override fun onClick(v: View) {


        when(v.id){
            R.id.HiltUse -> {
                startActivity(Intent(this,HiltActivity::class.java))
            }

            R.id.LiveDataUse ->{
                startActivity(Intent(this,
                    LiveDataUse3Activity::class.java))
            }

            R.id.DataBindingUse ->{
                startActivity(Intent(this,
                    DataBindUseActivity::class.java))
            }

            R.id.ViewModelUse ->{
                startActivity(
                    Intent(
                    this,ViewModelActivity::class.java
                )
                )
            }
        }
    }
}