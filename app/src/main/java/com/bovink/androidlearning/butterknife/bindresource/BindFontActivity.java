package com.bovink.androidlearning.butterknife.bindresource;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindColor;
import butterknife.BindFont;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindFontActivity extends AppCompatActivity {

    @BindFont(R.font.pianpianti)
    Typeface typeface1;

    @BindFont(value = R.font.pianpianti, style = Typeface.ITALIC)
    Typeface typeface2;

    @BindColor(R.color.colorAccent)
    int color;

    @BindView(R.id.tv_text1)
    TextView textView1;

    @BindView(R.id.tv_text2)
    TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);

        testBindFont();
    }

    private void testBindFont() {
        textView1.setTextColor(color);
        textView1.setTypeface(typeface1);

        textView2.setTextColor(color);
        textView2.setTypeface(typeface2);
    }

}
