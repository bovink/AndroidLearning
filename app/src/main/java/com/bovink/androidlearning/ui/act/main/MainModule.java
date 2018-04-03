package com.bovink.androidlearning.ui.act.main;

import com.bovink.androidlearning.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @ActivityScoped
    @Provides
    MainContract.Presenter providesPresenter(MainPresenter presenter) {
        return presenter;
    }
}