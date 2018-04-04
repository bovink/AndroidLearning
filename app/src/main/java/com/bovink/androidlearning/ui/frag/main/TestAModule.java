package com.bovink.androidlearning.ui.frag.main;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class TestAModule {
    
    @FragmentScoped
    @Provides
    TestAContract.Presenter providesPresenter(TestAPresenter presenter) {
        return presenter;
    }
}
