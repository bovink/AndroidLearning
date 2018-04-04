package com.bovink.androidlearning.ui.frag.mine;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class MineModule {

    @FragmentScoped
    @Provides
    MineContract.Presenter providesPresenter(MinePresenter presenter) {
        return presenter;
    }
}
