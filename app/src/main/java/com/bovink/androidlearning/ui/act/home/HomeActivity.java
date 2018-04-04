package com.bovink.androidlearning.ui.act.home;

import android.content.Context;
import android.os.Bundle;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class HomeActivity extends DaggerAppCompatActivity {

    @Inject
    HomeFragment mFragment;

    @Inject
    HomePresenter mPresenter;

    @Inject
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_home_content, mFragment)
                .commit();
    }
}
