package com.bovink.androidlearning;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    private TextView tv_text;
    private Button btn_click;

    private MyViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.e(TAG, "onCreate");
        tv_text = findViewById(R.id.tv_text);
        btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(this);

        vm = ViewModelProviders.of(this).get(MyViewModel.class);
        vm.getNumbers().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                tv_text.setText("" + integer);
                Log.e(TAG, "onChanged:" + integer);

            }
        });

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        vm.startThread();
    }
}
