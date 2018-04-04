package com.bovink.androidlearning.ui.act.main;

import com.bovink.androidlearning.di.FragmentScoped;
import com.bovink.androidlearning.ui.frag.book.BookFragFragment;
import com.bovink.androidlearning.ui.frag.book.BookFragFragmentBuilder;
import com.bovink.androidlearning.ui.frag.book.BookFragModule;
import com.bovink.androidlearning.ui.frag.home.HomeFragment;
import com.bovink.androidlearning.ui.frag.home.HomeModule;
import com.bovink.androidlearning.ui.frag.mine.MineFragment;
import com.bovink.androidlearning.ui.frag.mine.MineModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public abstract class MainFragmentBuilder {

    @FragmentScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeFragment bindTestAFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = MineModule.class)
    abstract MineFragment bindTestBFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = {BookFragModule.class, BookFragFragmentBuilder.class})
    abstract BookFragFragment bindBookFragFragment();
}
