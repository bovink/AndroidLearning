package com.bovink.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bovink.androidlearning.service.HelloIntentService;
import com.bovink.androidlearning.service.NormalService;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ExampleActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, BindServiceActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btn_service_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, NormalService.class);
                startService(i);
            }
        });

        findViewById(R.id.btn_normal_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i(TAG, "服务线程运行中");
                        }

                    }
                }).start();
            }
        });

        findViewById(R.id.btn_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, HelloIntentService.class);
                startService(i);
            }
        });
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(MainActivity.this, HelloIntentService.class);
                i.setAction(HelloIntentService.START_ACTION);
                startService(i);
                Log.i(TAG,"click");
            }
        });

        Log.i(TAG, "当前主线程："+Thread.currentThread().getId());
    }
}
