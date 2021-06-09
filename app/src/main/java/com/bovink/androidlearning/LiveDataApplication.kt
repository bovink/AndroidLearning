package com.bovink.androidlearning

import android.app.Application
import timber.log.Timber

/**
 * @author bovink
 * @since 2021/6/9
 */
class LiveDataApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}