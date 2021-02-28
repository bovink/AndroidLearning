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
    private Looper looper;

    public LooperWorker() {
        super(TAG);
        start();
        handler = new Handler(getLooper());
    }

    public Looper getLooper() {
        if (!isAlive()) {
            return null;
        }

        // If the thread has been started, wait until the looper has been created.
        synchronized (this) {
            while (isAlive() && looper == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return looper;
    }


    @Override
    public void run() {
        Looper.prepare();
        synchronized (this) {
            looper = Looper.myLooper();
            notifyAll();
        }

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
