package com.bovink.androidlearning;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class Worker extends HandlerThread {

    private final Handler handler;
    private static final String TAG = SimpleWorker.class.getName();

    public Worker() {
        super(TAG);
        start();
        handler = new Handler(getLooper());
    }

    public Worker execute(Runnable task) {
        handler.post(task);
        return this;
    }
}
