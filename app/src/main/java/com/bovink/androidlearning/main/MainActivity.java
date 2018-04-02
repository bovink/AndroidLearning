package com.bovink.androidlearning.main;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(mContext, "Hello, Dagger", Toast.LENGTH_LONG).show();
    }
}
