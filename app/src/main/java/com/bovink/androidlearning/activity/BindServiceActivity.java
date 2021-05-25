package com.bovink.androidlearning.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.service.LongWork;

/**
 * @author bovink
 * @since 2021/3/5
 */
public class BindServiceActivity extends AppCompatActivity {

    private static final String TAG = BindServiceActivity.class.getName();
    private LongWork longWork;
    private boolean mBound;
    /*
     *   也许考虑单独弄一个单例类。
     */
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.i(TAG, "onServiceConnected");
            LongWork.MyBinder binder = (LongWork.MyBinder) service;
            longWork = binder.getService();
            mBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected");
            mBound = false;

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindservice);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, LongWork.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mBound = false;
    }

    public void onEnterAct(View v) {

        Intent i = new Intent(this, BindServiceActivity.class);
        startActivity(i);

    }

    public void onBtnClick(View v) {
        if (mBound) {

            int result = longWork.getRandomNumber();
            Toast.makeText(this, "number: " + result, Toast.LENGTH_SHORT).show();

        }

    }


}
