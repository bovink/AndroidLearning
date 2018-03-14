package com.bovink.androidlearning.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bovink.androidlearning.BR;

/**
 * @author fox
 * @since 2018/03/14
 */

public class Student extends BaseObservable {

    private String name;
    private String className;
    private String teacher;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        notifyPropertyChanged(BR.className);
    }

    @Bindable
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
        notifyPropertyChanged(BR.teacher);
    }
}
