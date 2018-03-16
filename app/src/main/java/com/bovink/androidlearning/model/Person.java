package com.bovink.androidlearning.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bovink.androidlearning.BR;

/**
 * 普通的JSON对象就能满足DataBinding的数据类型要求
 *
 * @author fox
 * @since 2018/03/09
 */

public class Person extends BaseObservable {

    private String name;
    private String age;
    private String nickName;
    private String sex;
    private boolean isAdult;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }
}
