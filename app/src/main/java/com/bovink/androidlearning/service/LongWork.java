package com.bovink.androidlearning.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * @author bovink
 * @since 2021/3/5
 */
public class LongWork extends Service {

    private static final String TAG = LongWork.class.getName();
    private final MyBinder binder = new MyBinder();
    private final Random mGenerator = new Random();

    public class MyBinder extends Binder {

        public LongWork getService() {
            return LongWork.this;
        }
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return binder;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}
