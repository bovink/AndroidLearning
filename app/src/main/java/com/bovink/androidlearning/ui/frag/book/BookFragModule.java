package com.bovink.androidlearning.ui.frag.book;

import com.bovink.androidlearning.di.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public class BookFragModule {

    @FragmentScoped
    @Provides
    BookFragContract.Presenter providesPresenter(BookFragPresenter presenter) {
        return presenter;
    }
}
