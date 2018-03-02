package com.bovink.androidlearning.butterknife.bindviews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

import butterknife.ButterKnife;

/**
 * @author fox
 * @since 2018/03/02
 */

public class BindViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindviews);
        ButterKnife.bind(this);
    }
}
