package com.bovink.androidlearning;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author bovink
 * @since 2021/2/28
 */
public class SimpleWorker extends Thread {

    private static final String TAG = SimpleWorker.class.getName();
    private AtomicBoolean alive = new AtomicBoolean(true);
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

    public SimpleWorker() {
        super(TAG);
    }

    @Override
    public void run() {
        while (alive.get()) {
            Runnable task = taskQueue.poll();
            if (task != null) {
                task.run();
            }

        }
        Log.i(TAG, "SimpleWorker Terminate");
    }

    public SimpleWorker execute(Runnable task) {
        taskQueue.add(task);
        return this;
    }

    public void quit() {
        alive.set(false);
    }
}
