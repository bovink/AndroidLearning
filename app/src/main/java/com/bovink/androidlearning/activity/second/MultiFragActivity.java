package com.bovink.androidlearning.activity.second;

import android.content.Context;
import android.os.Bundle;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MultiFragActivity extends DaggerAppCompatActivity {

    @Inject
    MultiFragFragment mFragment;

    @Inject
    MultiFragPresenter mPresenter;

    @Inject
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main_content, mFragment)
                .commit();
    }
}
