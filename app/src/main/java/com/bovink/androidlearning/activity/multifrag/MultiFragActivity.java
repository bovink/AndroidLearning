package com.bovink.androidlearning.activity.multifrag;

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
        setContentView(R.layout.act_multi_frag);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_multifrag_content, mFragment)
                .commit();
    }
}
