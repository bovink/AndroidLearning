package com.bovink.androidlearning;

import android.arch.lifecycle.LiveData;

/**
 * @author bovink
 * @since 2021/1/13
 */
class StockLiveData extends LiveData<Integer> {

    @Override
    protected void onActive() {
        super.onActive();
        System.out.println("StockLiveData.onActive");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        System.out.println("StockLiveData.onInactive");
    }
}
