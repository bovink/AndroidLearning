package com.bovink.androidlearning;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/3/4
 */
public class SimpleWork extends Service {

    private static SimpleWork mInstance = null;
    private static final String TAG = SimpleWork.class.getName();

    public SimpleWork() {

    }

    public static SimpleWork getInstance() {
        if (mInstance == null) {
            mInstance = new SimpleWork();
        }
        return mInstance;
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

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (; ; ) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("服务运行中");
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
