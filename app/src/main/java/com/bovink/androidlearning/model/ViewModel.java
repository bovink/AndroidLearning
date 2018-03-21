package com.bovink.androidlearning.model;

import android.databinding.ObservableField;

/**
 * @author fox
 * @since 2018/03/21
 */

public class ViewModel {

    public final ObservableField<String> description = new ObservableField<>();

    public final ObservableField<Time> time = new ObservableField<>();

}
