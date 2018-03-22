package com.bovink.androidlearning;

import android.databinding.Observable;
import android.databinding.ObservableField;

import com.bovink.androidlearning.model.Student;

/**
 * @author fox
 * @since 2018/03/21
 */

public class MainViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>();

    private final ObservableField<Student> studentObservable = new ObservableField<>();

    public MainViewModel() {

        studentObservable.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Student student = studentObservable.get();
                if (student != null) {

                    name.set(student.getName());
                    age.set(student.getAge());
                } else {

                    name.set("null");
                    age.set("null");
                }
            }
        });
    }

    public void setStudentObservable(Student student) {
        studentObservable.set(student);
    }
}
