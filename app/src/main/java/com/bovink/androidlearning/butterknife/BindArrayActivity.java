package com.bovink.androidlearning.butterknife;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import butterknife.BindArray;
import butterknife.BindView;
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

    @BindArray(R.array.colors)
    TypedArray colors;

    @BindView(R.id.tv_hello)
    TextView helloTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);

        testBindArray();
        int index = 0;
        int color = colors.getColor(index, 0);
        helloTextView.setTextColor(color);
    }

    private void testBindArray() {

        for (String day : week) {
            System.out.println("day = " + day);
        }

        for (int month : months) {
            System.out.println("month = " + month);

        }
    }
}
