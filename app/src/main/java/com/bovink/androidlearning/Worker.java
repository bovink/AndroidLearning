package com.bovink.androidlearning;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class Worker extends HandlerThread {

    private static final String TAG = Worker.class.getName();
    private Handler handler;

    public Worker() {
        super(TAG);
    }

    public Worker execute(Runnable task) {
        Log.i(TAG, "" + Thread.currentThread().getId());
        handler.post(task);
        return this;
    }

    @Override
    protected void onLooperPrepared() {
        Log.i(TAG, "" + Thread.currentThread().getId());
        super.onLooperPrepared();
        handler = new Handler(getLooper());
    }
}
