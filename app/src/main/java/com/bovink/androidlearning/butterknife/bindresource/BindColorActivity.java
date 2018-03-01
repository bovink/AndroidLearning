package com.bovink.androidlearning.butterknife.bindresource;

import android.content.res.ColorStateList;
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
    @BindColor(R.color.text_click)
    ColorStateList textClickColorStateList;

    @BindView(R.id.tv_text1)
    TextView textView1;
    @BindView(R.id.tv_text2)
    TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindresource_color);
        ButterKnife.bind(this);

        textView1.setTextColor(accentColor);

        textView2.setClickable(true);
        textView2.setTextColor(textClickColorStateList);
    }
}
