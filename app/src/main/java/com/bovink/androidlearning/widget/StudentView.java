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
    private String grade = "null";

    public StudentView(Context context) {
        super(context);
    }

    public StudentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StudentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindingAdapter("name")
    public static void setName(StudentView view, String name) {
        view.name = name;
        view.setPersonInfo(name, view.getAge());
    }

    public void setAge(String age) {
        // will override if BindingAdapter("name") exist.
        this.age = age;
        setText(age);
    }

    @BindingAdapter("age")
    public static void setAge(StudentView view, String age) {
        view.age = age;
        view.setPersonInfo(view.getName(), age);
    }

    @BindingAdapter({"name", "age"})
    public static void setPersonInfoText(StudentView view, String name, String age) {

        view.name = name;
        view.age = age;
        view.setPersonInfo(name, age + " it's from multiple parameter");
    }

    @BindingAdapter("grade")
    public static void setGrade(StudentView view, String oldGrade, String newGrade) {
        System.out.println("StudentView.setGrade");
        if (oldGrade != null && !oldGrade.equals(newGrade)) {

            view.grade = newGrade;
            view.setGradeInfo(newGrade + " different grade");
        } else {

            view.grade = newGrade;
            view.setGradeInfo(newGrade + " same grade");
        }
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

    public void setGradeInfo(String grade) {

        String content = "my name is " + this.name + " and i'm " + this.age + " and i'm " + grade;
        setText(content);
    }
}
