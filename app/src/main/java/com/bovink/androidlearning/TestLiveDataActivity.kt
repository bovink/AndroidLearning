package com.bovink.androidlearning

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlin.concurrent.thread

/**
 * @author bovink
 * @since 2021/3/16
 */
class TestLiveDataActivity : AppCompatActivity() {

    var liveData: MutableLiveData<Int> = MutableLiveData()
    var normalData: Int = 0
    var liveDataText: TextView? = null
    var normalDataText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_livedata)


        println("Main Thread ${Thread.currentThread().id}")

        val numObserver = Observer<Int> { newInt ->
            println("Thread ${Thread.currentThread().id} LiveData Print $newInt")
            liveDataText?.post { liveDataText?.text = newInt.toString() }
        }

        liveData.observe(this, numObserver)

        thread {
            for (i in 0 until 10) {

                Thread.sleep(1000)
                liveData.postValue(i)
                normalData = i
                println("Thread ${Thread.currentThread().id} Normal print $normalData")
                normalDataText?.post { normalDataText?.text = normalData.toString() }
            }
            println("Thread Terminated")
        }
    }

    override fun onStop() {
        super.onStop()
        liveDataText = null
        normalDataText = null
    }

    override fun onStart() {
        super.onStart()
        liveDataText = findViewById(R.id.tv_livedata)
        normalDataText = findViewById(R.id.tv_normaldata)
    }
}