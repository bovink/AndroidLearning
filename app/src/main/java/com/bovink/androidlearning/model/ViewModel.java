package com.bovink.androidlearning.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.bovink.androidlearning.BR;

/**
 * @author fox
 * @since 2018/03/21
 */

public class ViewModel extends BaseObservable {

    public final ObservableField<String> description = new ObservableField<>();

    public final ObservableField<Time> time = new ObservableField<>();

    public final ObservableField<Time> anotherTime = new ObservableField<>();


    public void setAnotherTime(Time time) {
        anotherTime.set(time);
    }

    public void setAnotherTimeString(String hour) {

        anotherTime.get().setHour(hour);
        notifyPropertyChanged(BR.anotherTimeString);
    }

    @Bindable
    public String getAnotherTimeString() {

        return anotherTime.get().getHour();
    }
}
