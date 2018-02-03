package com.bovink.androidlearning.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;

import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * com.bovink.androidlearning.butterknife.bindevent
 *
 * @author bovink
 * @since 2018/2/3
 */

public class OnTextChangedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindevent_ontextchanged);
        ButterKnife.bind(this);
    }

    @OnTextChanged(value = {R.id.et_test})
    void onTextChanged(CharSequence charSequence) {

        System.out.println("charSequence = " + charSequence);
    }
}
