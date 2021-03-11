package com.bovink.androidlearning.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bovink.androidlearning.WorkThread;

/**
 * @author bovink
 * @since 2021/3/5
 */
public class NormalService extends Service {
    private static final String TAG = NormalService.class.getName();
    private Handler handler;
    private Looper looper;

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
        WorkThread thread = new WorkThread();
        thread.start();
        looper = thread.getLooper();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        handler = new Handler(looper);
        handler.post(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "子线程：" + Thread.currentThread().getId());

            }
        });

        Log.i(TAG, "当前线程：" + Thread.currentThread().getId());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        looper.quit();
        super.onDestroy();
    }
}
