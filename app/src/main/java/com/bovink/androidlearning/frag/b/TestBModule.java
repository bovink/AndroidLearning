package com.bovink.androidlearning.frag.b;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class TestBModule {

    @FragmentScoped
    @Provides
    TestBContract.Presenter providesPresenter(TestBPresenter presenter) {
        return presenter;
    }
}
