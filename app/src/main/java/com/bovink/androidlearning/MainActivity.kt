package com.bovink.androidlearning

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import timber.log.Timber
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), LifecycleObserver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.i("onCreate called")
        lifecycle.addObserver(this)
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy called")
    }

    fun gotoLiveDataTest(v: View) {

        val intent = Intent(this, TestLiveDataActivity::class.java)
        startActivity(intent)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun showCreate() {

        Timber.i("showCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun showStart() {

        Timber.i("showStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun showResume() {

        Timber.i("showResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun showPause() {

        Timber.i("showPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun showStop() {

        Timber.i("showStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun showDestroy() {
        Timber.i("showDestroy")

    }


}