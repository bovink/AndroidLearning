package com.bovink.androidlearning

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var num: MutableLiveData<Int> = MutableLiveData()
    var normalNum: Int = 0
     var tv:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val numObserver = Observer<Int> { newInt ->
            println(newInt)
        }

        num.observe(this, numObserver)

        thread {
            for (i in 1..5) {

                Thread.sleep(1000)
                num.postValue(i)
                normalNum = i
                println(normalNum)
                tv?.post { tv?.text = normalNum.toString() }
            }
            println("end")
        }
    }

    override fun onStop() {
        super.onStop()
        tv = null
    }

    override fun onStart() {
        super.onStart()
        tv = findViewById(R.id.textView)
    }
}