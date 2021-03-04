package com.bovink.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author bovink
 * @since 2021/3/4
 */
public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

//        SimpleWork simpleWork = SimpleWork.getInstance();
        Intent intent = new Intent(this, SimpleWork.class);
        startService(intent);
    }
}
