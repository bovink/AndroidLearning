package com.bovink.androidlearning;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * @author bovink
 * @since 2021/3/5
 */
public class BindServiceActivity extends AppCompatActivity {

    private static final String TAG = BindServiceActivity.class.getName();
    /*
     *   也许考虑单独弄一个单例类。
     */
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.i(TAG, "onStartCommand");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onStartCommand");

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindservice);

        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), LongWork.class);
                bindService(i, conn, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn_unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                unbindService(conn);
            }
        });
    }
}
