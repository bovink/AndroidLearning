package com.bovink.androidlearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author bovink
 * @since 2021/3/4
 */
public class WindowActivity extends AppCompatActivity {

    private static final String TAG = WindowActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "==============================onCreate");
        setContentView(R.layout.activity_window);

        setFinishOnTouchOutside(false);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "==============================onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "==============================onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "==============================onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "==============================onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "==============================onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "==============================onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "==============================onDestroy");
    }
}
