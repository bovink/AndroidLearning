package com.bovink.androidlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bovink.androidlearning.R;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "当前主线程：" + Thread.currentThread().getId());
    }

    private void bindBtnClickListeners() {

        findViewById(R.id.btn_goto_intentservice_act).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, IntentServiceActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_goto_bind_act).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, BindServiceActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_goto_normalservice_act).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, NormalServiceActivity.class);
                startActivity(i);
            }
        });


    }
}
