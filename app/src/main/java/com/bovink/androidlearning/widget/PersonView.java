package com.bovink.androidlearning.widget;

import android.content.Context;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * com.bovink.androidlearning.widget
 *
 * @author bovink
 * @since 2018/3/15
 */

@BindingMethods({
        @BindingMethod(type = com.bovink.androidlearning.widget.PersonView.class,
                attribute = "personName",
                method = "setName"),
        @BindingMethod(type = com.bovink.androidlearning.widget.PersonView.class,
                attribute = "personNameColor",
                method = "setNameColor")
})
public class PersonView extends AppCompatTextView {

    public PersonView(Context context) {
        super(context);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setName(String name) {
        setText(name);
    }

    public void setNameColor(String color) {

        setTextColor(Color.parseColor(color));
    }
}
