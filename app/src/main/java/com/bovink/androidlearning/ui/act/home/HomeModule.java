package com.bovink.androidlearning.ui.act.home;

import com.bovink.androidlearning.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @ActivityScoped
    @Provides
    HomeContract.Presenter providesPresenter(HomePresenter presenter) {
        return presenter;
    }
}