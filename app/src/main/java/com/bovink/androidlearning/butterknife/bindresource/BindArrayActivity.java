package com.bovink.androidlearning.butterknife.bindresource;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * com.bovink.androidlearning.butterknife
 *
 * @author bovink
 * @since 2018/1/29
 */

public class BindArrayActivity extends AppCompatActivity {

    @BindArray(R.array.week)
    String[] week;

    @BindArray(R.array.month)
    int[] months;

    @BindArray(R.array.week)
    CharSequence[] charSequences;

    @BindArray(R.array.color)
    TypedArray colors;

    @BindViews({R.id.tv_text1, R.id.tv_text2, R.id.tv_text3})
    List<TextView> textViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bindresource_array);
        ButterKnife.bind(this);

        testBindArray();

        for (int i = 0; i < colors.length(); i++) {

            int color = colors.getColor(i, 0);
            textViews.get(i).setTextColor(color);
        }
    }

    private void testBindArray() {

        for (String day : week) {
            System.out.println("day = " + day);
        }

        for (int month : months) {
            System.out.println("month = " + month);
        }

        for (CharSequence ch : charSequences) {
            System.out.println("ch = " + ch);
        }
    }
}
