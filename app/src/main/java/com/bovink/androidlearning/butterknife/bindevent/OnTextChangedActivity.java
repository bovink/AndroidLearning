package com.bovink.androidlearning.butterknife.bindevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;

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

    /**
     * 默认callback是TEXT_CHANGED
     */
    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onTextChanged(CharSequence s, int start, int before, int count) {

        System.out.println("OnTextChangedActivity.onTextChanged");
        System.out.println("s = " + s);
        System.out.println("start = " + start);
        System.out.println("before = " + before);
        System.out.println("count = " + count);
    }

    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTextChanged(CharSequence s, int start, int count, int after) {

        System.out.println("OnTextChangedActivity.beforeTextChanged");
        System.out.println("s = " + s);
        System.out.println("start = " + start);
        System.out.println("count = " + count);
        System.out.println("after = " + after);
    }

    @OnTextChanged(value = R.id.et_test, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextChanged(Editable s) {
        
        System.out.println("OnTextChangedActivity.afterTextChanged");
        System.out.println("s.toString() = " + s.toString());
    }

}
