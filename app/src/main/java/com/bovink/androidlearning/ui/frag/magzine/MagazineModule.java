package com.bovink.androidlearning.ui.frag.magzine;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class MagazineModule {
    
    @FragmentScoped
    @Provides
    MagazineContract.Presenter providesPresenter(MagazinePresenter presenter) {
        return presenter;
    }
}
