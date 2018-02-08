package com.bovink.androidlearning.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/02/08
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @OnClick(R.id.btn_test)
    void clickBtn() {

        System.out.println("TestActivity.clickBtn");
    }
}
