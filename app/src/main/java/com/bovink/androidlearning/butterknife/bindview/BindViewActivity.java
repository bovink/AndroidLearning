package com.bovink.androidlearning.butterknife.bindview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fox
 * @since 2018/03/02
 */

public class BindViewActivity extends AppCompatActivity {

    @BindView(R.id.tv_test1)
    TextView testTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindview);

        ButterKnife.bind(this);

        testTextView.setText("bind view from activity");

        BindViewFragment fragment = BindViewFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_fragment, fragment)
                .commit();
    }
}
