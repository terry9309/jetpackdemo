package com.example.jetpackdemo.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jetpackdemo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//step:5
@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {


    //step:6
    @Inject
    lateinit var p:Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        Toast.makeText(this,"My Name:${p.name},My age${p.age}",Toast.LENGTH_SHORT).show()
    }
}