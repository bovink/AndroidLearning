package com.bovink.androidlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.service.SimpleWork;

/**
 * @author bovink
 * @since 2021/3/4
 */
public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Intent intent = new Intent(getApplicationContext(), SimpleWork.class);
        startService(intent);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExampleActivity.this, SimpleWork.class);
                stopService(intent);
            }
        });
    }
}
