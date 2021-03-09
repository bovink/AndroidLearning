package com.bovink.androidlearning;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class AndroidHighWorker extends HandlerThread {

    private static final String TAG = AndroidHighWorker.class.getName();
    private Handler handler;

    public AndroidHighWorker() {
        super(TAG);
    }

    public AndroidHighWorker execute(Runnable task) {
        Log.i(TAG, "所在线程:" + Thread.currentThread().getId());
        handler.post(task);
        return this;
    }

    @Override
    protected void onLooperPrepared() {
        Log.i(TAG, "所在线程:" + Thread.currentThread().getId());
        super.onLooperPrepared();
        handler = new Handler(getLooper());
    }
}
