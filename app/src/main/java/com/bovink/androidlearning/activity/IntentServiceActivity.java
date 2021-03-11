package com.bovink.androidlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.service.HelloIntentService;

/**
 * @author bovink
 * @since 2021/3/4
 */
public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        findViewById(R.id.btn_start_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntentServiceActivity.this, HelloIntentService.class);
                intent.setAction(HelloIntentService.START_ACTION);
                startService(intent);
            }
        });

        findViewById(R.id.btn_stop_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntentServiceActivity.this, HelloIntentService.class);
                stopService(intent);
            }
        });

    }
}
