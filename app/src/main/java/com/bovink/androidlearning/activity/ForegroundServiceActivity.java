package com.bovink.androidlearning.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.service.ForegroundService;

/**
 * @author bovink
 * @since 2021/3/12
 */
public class ForegroundServiceActivity extends AppCompatActivity {
    private static final String TAG = ForegroundServiceActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_foreground_service);
        Log.i(TAG, "当前主线程：" + Thread.currentThread().getId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = new Intent(this, ForegroundService.class);
        stopService(i);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent i = new Intent(this, ForegroundService.class);
            startForegroundService(i);
        }
    }
}
