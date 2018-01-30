package com.bovink.androidlearning.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindBitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
    }
}
