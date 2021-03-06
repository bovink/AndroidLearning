package com.bovink.androidlearning.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/3/6
 */
public class HelloIntentService extends IntentService {
    public static final String START_ACTION = "start_action";

    private static final String TAG = HelloIntentService.class.getName();

    public HelloIntentService() {
        super("HelloIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (intent.getAction() != null &&intent.getAction().equals(START_ACTION)) {


            Log.i(TAG, "当前服务线程："+Thread.currentThread().getId());
            Log.i(TAG, "startTask");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Log.i(TAG, "endTask");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

    }
}
