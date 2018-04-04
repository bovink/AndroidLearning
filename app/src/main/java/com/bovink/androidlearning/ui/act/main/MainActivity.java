package com.bovink.androidlearning.ui.act.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

public class MainActivity extends AppCompatActivity {

    MainFragment mFragment;

    MainPresenter mPresenter;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main_content, mFragment)
                .commit();
    }
}
