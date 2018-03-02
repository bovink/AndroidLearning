package com.bovink.androidlearning.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindStringActivity extends AppCompatActivity {

    @BindString(R.string.app_name)
    String mAppName;

    @BindView(R.id.tv_test)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindresource_string);
        ButterKnife.bind(this);

        testBindString();
    }

    private void testBindString() {
        testTextView.setText(mAppName);
    }
}
