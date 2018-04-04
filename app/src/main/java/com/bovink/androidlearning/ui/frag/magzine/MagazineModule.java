package com.bovink.androidlearning.ui.frag.magzine;

import com.bovink.androidlearning.di.ViewPagerFragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class MagazineModule {
    
    @ViewPagerFragmentScoped
    @Provides
    MagazineContract.Presenter providesPresenter(MagazinePresenter presenter) {
        return presenter;
    }
}
