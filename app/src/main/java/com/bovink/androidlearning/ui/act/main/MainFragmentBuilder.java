package com.bovink.androidlearning.ui.act.main;

import com.bovink.androidlearning.di.FragmentScoped;
import com.bovink.androidlearning.ui.frag.book.BookFragment;
import com.bovink.androidlearning.ui.frag.book.BookFragmentBuilder;
import com.bovink.androidlearning.ui.frag.book.BookModule;
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
    abstract HomeFragment bindHomeFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = {BookModule.class, BookFragmentBuilder.class})
    abstract BookFragment bindBookFragment();

    @FragmentScoped
    @ContributesAndroidInjector(modules = MineModule.class)
    abstract MineFragment bindMineFragment();
}
