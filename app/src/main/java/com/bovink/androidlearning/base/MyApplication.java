package com.bovink.androidlearning.base;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MyApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
