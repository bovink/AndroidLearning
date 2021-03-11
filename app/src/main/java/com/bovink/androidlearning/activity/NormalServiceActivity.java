package com.bovink.androidlearning.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.service.NormalService;

/**
 * @author bovink
 * @since 2021/3/11
 */
public class NormalServiceActivity extends AppCompatActivity {
    private static final String TAG = NormalServiceActivity.class.getName();

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normalservice);

        mContext = this;
        bindBtnClickListeners();
    }

    private void bindBtnClickListeners() {
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, NormalService.class);
                startService(i);
            }
        });

        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, NormalService.class);
                stopService(i);
            }
        });

    }
}
