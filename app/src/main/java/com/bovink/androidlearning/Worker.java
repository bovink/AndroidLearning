package com.bovink.androidlearning;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class Worker extends HandlerThread {

    private  Handler handler;
    private static final String TAG = SimpleWorker.class.getName();

    public Worker() {
        super(TAG);
    }

    public Worker execute(Runnable task) {
        handler.post(task);
        return this;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        handler = new Handler(getLooper());
    }
}
