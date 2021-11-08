package com.example.jetpackdemo.hilt

import javax.inject.Inject


//step:4
data  class Person constructor(val name:String,val age:Int) {

     @Inject
     constructor():this("terry",18)
}