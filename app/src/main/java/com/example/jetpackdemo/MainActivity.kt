package com.example.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jetpackdemo.hilt.HiltActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HiltUse.setOnClickListener(this)
    }

    override fun onClick(v: View) {


        when(v.id){
            R.id.HiltUse -> {
                startActivity(Intent(this,HiltActivity::class.java))
            }
        }
    }
}