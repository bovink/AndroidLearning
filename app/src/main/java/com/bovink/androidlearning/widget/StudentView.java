package com.bovink.androidlearning.widget;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @author fox
 * @since 2018/03/16
 */

public class StudentView extends AppCompatTextView {

    private String name = "null";
    private String age = "null";

    public StudentView(Context context) {
        super(context);
    }

    public StudentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StudentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindingAdapter("personName")
    public static void setName(StudentView view, String name) {
        view.name = name;
        view.setPersonInfo(name, view.getAge());
    }

    @BindingAdapter("personAge")
    public static void setAge(StudentView view, String age) {
        view.age = age;
        view.setPersonInfo(view.getName(), age);
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }


    public void setPersonInfo(String name, String age) {

        String content = "my name is " + name + " and i'm " + age;
        setText(content);
    }
}
