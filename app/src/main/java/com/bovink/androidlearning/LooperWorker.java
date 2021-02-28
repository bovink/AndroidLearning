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
        start();
        handler = new Handler(Looper.myLooper());
    }

    @Override
    public void run() {
        Looper.prepare();

        Looper.loop();
        Log.i(TAG, "LooperWorker Terminate");
    }

    public LooperWorker execute(Runnable task) {
        handler.post(task);
        return this;
    }

    public void quit() {
        Looper looper = Looper.myLooper();
        if (looper != null) {
            looper.quit();
        }
    }
}
