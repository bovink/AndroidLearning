package com.bovink.androidlearning.ui.act.home;

import com.bovink.androidlearning.di.FragmentScoped;
import com.bovink.androidlearning.ui.frag.book.BookFragFragment;
import com.bovink.androidlearning.ui.frag.book.BookFragModule;
import com.bovink.androidlearning.ui.frag.main.TestAFragment;
import com.bovink.androidlearning.ui.frag.main.TestAModule;
import com.bovink.androidlearning.ui.frag.mine.TestBFragment;
import com.bovink.androidlearning.ui.frag.mine.TestBModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public abstract class MultiFragFragmentBuilder {

    @FragmentScoped
    @ContributesAndroidInjector(modules = TestAModule.class)
    abstract TestAFragment bindTestAFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = TestBModule.class)
    abstract TestBFragment bindTestBFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = {BookFragModule.class})
    abstract BookFragFragment bindBookFragFragment();
}
