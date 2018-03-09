package com.bovink.androidlearning.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bovink.androidlearning.BR;

/**
 * @author fox
 * @since 2018/03/09
 */

public class Person extends BaseObservable{

    private String name;
    private String sex;



    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }
}
