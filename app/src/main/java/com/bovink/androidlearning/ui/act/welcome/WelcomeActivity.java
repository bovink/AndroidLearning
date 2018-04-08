package com.bovink.androidlearning.ui.act.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

public class WelcomeActivity extends AppCompatActivity {

    WelcomeFragment mFragment;

    WelcomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_welcome);

        mPresenter = new WelcomePresenter();
        mFragment = WelcomeFragment.newInstance(mPresenter);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_welcome_content, mFragment)
                .commit();
    }
}
