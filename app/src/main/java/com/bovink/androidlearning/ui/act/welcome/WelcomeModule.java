package com.bovink.androidlearning.ui.act.welcome;

import com.bovink.androidlearning.di.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class WelcomeModule {

    @ActivityScoped
    @Provides
    WelcomeContract.Presenter providesPresenter(WelcomePresenter presenter) {
        return presenter;
    }
}