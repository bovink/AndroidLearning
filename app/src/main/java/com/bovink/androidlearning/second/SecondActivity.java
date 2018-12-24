package com.bovink.androidlearning.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

/**
 * @author bovink
 * @since 2018/12/24
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ThirdFragment thirdFragment = new ThirdFragment();
        showFragment(R.id.fl_third, thirdFragment);

        FourthFragment fourthFragment = new FourthFragment();
        showFragment(R.id.fl_fourth, fourthFragment);

    }

    private void showFragment(int layoutId, Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(layoutId, fragment)
                .commit();
    }
}
