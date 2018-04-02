package com.bovink.androidlearning.activity.multifrag;

import com.bovink.androidlearning.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class MultiFragModule {

    @ActivityScoped
    @Provides
    MultiFragContract.Presenter providesPresenter(MultiFragPresenter presenter) {
        return presenter;
    }
}