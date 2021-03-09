package com.bovink.androidlearning;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class AndroidWorker extends Thread {

    private static final String TAG = AndroidWorker.class.getName();
    public Handler handler;

    public AndroidWorker() {
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

    public AndroidWorker execute(Runnable task) {
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
