package com.bovink.androidlearning;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * @author bovink
 * @since 2021/1/12
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> numbers;

    public LiveData<Integer> getNumbers() {
        if(numbers == null) {
            numbers = new MutableLiveData<>();
        }
        return numbers;
    }

    public void startThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                int n = 0;
                while (n < 5) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    n++;
                    numbers.postValue(n);

                }

            }
        }).start();
    }
}
