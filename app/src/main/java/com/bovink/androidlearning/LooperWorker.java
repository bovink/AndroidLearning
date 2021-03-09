package com.bovink.androidlearning;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class LooperWorker extends Thread {

    private static final String TAG = LooperWorker.class.getName();
    public Handler handler;

    public LooperWorker() {
        super(TAG);
    }

    @Override
    public void run() {
        Log.i(TAG, "" + Thread.currentThread().getId());
        Looper.prepare();

        handler = new Handler(Looper.myLooper());

        Looper.loop();
        Log.i(TAG, "LooperWorker Terminate");
    }

    public LooperWorker execute(Runnable task) {
        Log.i(TAG, "" + Thread.currentThread().getId());
        handler.post(task);
        return this;
    }

    public void quit() {
        Looper looper = handler.getLooper();
        if (looper != null) {
            looper.quit();
        }
    }
}
