package com.bovink.androidlearning;

import android.os.HandlerThread;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/3/11
 */
public class WorkThread extends HandlerThread {
    private static final String TAG = WorkThread.class.getName();

    public WorkThread() {
        super("service");
    }

    @Override
    public void run() {
        super.run();
        Log.i(TAG, "Terminated");
    }
}
