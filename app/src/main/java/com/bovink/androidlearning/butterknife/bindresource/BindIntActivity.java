package com.bovink.androidlearning.butterknife.bindresource;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindIntActivity extends AppCompatActivity {

    @BindInt(R.integer.time)
    int time;

    @BindView(R.id.tv_text1)
    TextView helloTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindresource_int);
        ButterKnife.bind(this);

        testBindInt();
    }

    private void testBindInt() {

        helloTextView.setTextSize(time);
    }
}
