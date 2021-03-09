package com.bovink.androidlearning;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    Executor executor;
    private ProgressBar pb;
    private Button clickButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressBar);
        pb.setMax(100);
        pb.setProgress(0);

        clickButton = findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Click:" + pb.getProgress());
            }
        });
        textView = findViewById(R.id.textView);

        handler = new Handler(getMainLooper());
        executor = Executors.newSingleThreadExecutor();
//        executor = Executors.newFixedThreadPool(3);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "当前线程：" + Thread.currentThread().getId());
                while (true) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            pb.setProgress(pb.getProgress() + 1);
                            textView.setText(pb.getProgress() + "");
                        }
                    });
                    if (pb.getProgress() == pb.getMax()) {
                        break;
                    }
                }
                Log.i(TAG, "当前线程：" + Thread.currentThread().getId() + " Terminated");

            }
        });
        Log.i(TAG, "当前线程：" + Thread.currentThread().getId());

    }

    private Handler handler;

}
