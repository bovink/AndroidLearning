package com.bovink.androidlearning.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

import butterknife.BindBool;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindBoolActivity extends AppCompatActivity {

    @BindBool(R.bool.is_right)
    boolean isRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_bool);
        ButterKnife.bind(this);

        testBindBool();
    }

    private void testBindBool() {
        if (isRight) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}
