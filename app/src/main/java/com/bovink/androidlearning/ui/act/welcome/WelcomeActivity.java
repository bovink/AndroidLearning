package com.bovink.androidlearning.ui.act.welcome;

import android.content.Context;
import android.os.Bundle;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class WelcomeActivity extends DaggerAppCompatActivity {

    @Inject
    WelcomeFragment mFragment;

    @Inject
    WelcomePresenter mPresenter;

    @Inject
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_welcome);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_welcome_content, mFragment)
                .commit();
    }
}
