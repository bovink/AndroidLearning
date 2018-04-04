package com.bovink.androidlearning.ui.frag.comic;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class ComicModule {
    
    @FragmentScoped
    @Provides
    ComicContract.Presenter providesPresenter(ComicPresenter presenter) {
        return presenter;
    }
}
