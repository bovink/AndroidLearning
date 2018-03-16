package com.bovink.androidlearning.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * com.bovink.androidlearning.widget
 *
 * @author bovink
 * @since 2018/3/15
 */

public class TimeView extends AppCompatTextView {

    private String time = "00:00:00";

    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        setText(time);
    }

    public String getHour() {
        return time.substring(0, 2);
    }

    public void setHour(String hour) {
        this.time = hour + time.substring(2, 8);
        setText(time);
    }

}
