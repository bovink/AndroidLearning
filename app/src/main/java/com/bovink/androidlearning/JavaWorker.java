package com.bovink.androidlearning;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class JavaWorker extends Thread {

    private static final String TAG = JavaWorker.class.getName();
    private AtomicBoolean alive = new AtomicBoolean(true);
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

    public JavaWorker() {
        super(TAG);
    }

    @Override
    public void run() {
        Log.i(TAG, "所在线程:" + Thread.currentThread().getId());
        while (alive.get()) {
            Runnable task = taskQueue.poll();
            if (task != null) {
                task.run();
            }
        }
        Log.i(TAG, "Terminate");
    }

    public JavaWorker execute(Runnable task) {
        Log.i(TAG, "所在线程:" + Thread.currentThread().getId());
        taskQueue.add(task);
        return this;
    }

    public void quit() {
        alive.set(false);
    }
}
