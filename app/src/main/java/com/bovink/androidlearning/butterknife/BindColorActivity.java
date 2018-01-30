package com.bovink.androidlearning.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindColorActivity extends AppCompatActivity {

    @BindColor(R.color.colorAccent)
    int accentColor;
    @BindView(R.id.tv_hello)
    TextView helloTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);

        testBindColor();
    }

    private void testBindColor() {
        helloTextView.setTextColor(accentColor);
    }
}
