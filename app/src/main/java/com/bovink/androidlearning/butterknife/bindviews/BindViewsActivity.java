package com.bovink.androidlearning.butterknife.bindviews;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bovink.androidlearning.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * @author fox
 * @since 2018/03/02
 */

public class BindViewsActivity extends AppCompatActivity {

    @BindViews({R.id.tv_test1, R.id.tv_test2, R.id.tv_test3})
    List<TextView> textViewList;

    @BindViews({R.id.tv_test4, R.id.tv_test5, R.id.tv_test6})
    TextView[] textViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindviews);
        ButterKnife.bind(this);

        ButterKnife.apply(textViewList, SET_TEXT_SIZE_TO_20);

        int blue = Color.parseColor("#66CCFF");
        int gray = Color.parseColor("#CCCCCC");
        ButterKnife.apply(textViewList, SET_TEXT_COLOR, blue);
        ButterKnife.apply(textViews, SET_TEXT_COLOR_TO_BLACK, SET_TEXT_SIZE_TO_20);
    }

    static final ButterKnife.Action<TextView> SET_TEXT_SIZE_TO_20 = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {

            view.setTextSize(20);
        }
    };

    static final ButterKnife.Action<TextView> SET_TEXT_COLOR_TO_BLACK = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {

            int black = Color.parseColor("#000000");
            view.setTextColor(black);
        }
    };

    static final ButterKnife.Setter<TextView, Integer> SET_TEXT_COLOR = new ButterKnife.Setter<TextView, Integer>() {
        @Override
        public void set(@NonNull TextView view, Integer color, int index) {

            view.setTextColor(color);
        }
    };
}
