package com.bovink.androidlearning.butterknife;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindDrawableActivity extends AppCompatActivity {

    @BindDrawable(R.mipmap.ic_launcher)
    Drawable iconDrawable;

    @BindView(R.id.tv_hello)
    TextView helloTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);

        testBindDrawable();
    }

    private void testBindDrawable() {
        helloTextView.setBackground(iconDrawable);
    }

}
