package com.bovink.androidlearning;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
            private SimpleWorker worker;
//    private Worker worker;
//    private LooperWorker worker;

    private TextView tvMessage;

    private final Handler handler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvMessage.setText((String) msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        worker = new SimpleWorker();
//        worker = new Worker();
//        worker = new LooperWorker();
        worker.start();
        tvMessage = findViewById(R.id.tv_message);

        Log.i(TAG, "" + Thread.currentThread().getId());
    }

    @Override
    protected void onStart() {
        super.onStart();

        worker.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = Message.obtain();
                msg.obj = "Task 1 Complete";
                handler.sendMessage(msg);
            }
        }).execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = Message.obtain();
                msg.obj = "Task 2 Complete";
                handler.sendMessage(msg);

            }
        }).execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = Message.obtain();
                msg.obj = "Task 3 Complete";
                handler.sendMessage(msg);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        worker.quit();
    }
}
