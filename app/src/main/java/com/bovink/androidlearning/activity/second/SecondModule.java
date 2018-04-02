package com.bovink.androidlearning.activity.second;

import com.bovink.androidlearning.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {

    @ActivityScoped
    @Provides
    SecondContract.Presenter providesPresenter(SecondPresenter presenter) {
        return presenter;
    }
}