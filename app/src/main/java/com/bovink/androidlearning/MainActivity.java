package com.bovink.androidlearning;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.frag.FirstFragment;
import com.bovink.androidlearning.frag.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();
        showFragment(R.id.fl_first, firstFragment);

        SecondFragment secondFragment = new SecondFragment();
        showFragment(R.id.fl_second, secondFragment);

    }

    private void showFragment(int layoutId, Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(layoutId, fragment)
                .commit();
    }
}
