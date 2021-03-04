package com.bovink.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "==============================onCreate");
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExampleActivity.class);
                startActivity(intent);
            }
        });
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
