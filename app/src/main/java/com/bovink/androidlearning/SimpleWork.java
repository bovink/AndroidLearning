package com.bovink.androidlearning;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author bovink
 * @since 2021/3/4
 */
public class SimpleWork extends Service {

    private static final String TAG = SimpleWork.class.getName();
    private AtomicBoolean isAlive = new AtomicBoolean(false);

    public SimpleWork() {

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
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
        isAlive.set(true);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (isAlive.get()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("服务运行中");
                }
                System.out.println("线程服务结束");
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isAlive.set(false);
        Log.i(TAG, "onDestroy");
    }
}
