package com.bovink.androidlearning.ui.frag.home;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class HomeModule {
    
    @FragmentScoped
    @Provides
    HomeContract.Presenter providesPresenter(HomePresenter presenter) {
        return presenter;
    }
}
