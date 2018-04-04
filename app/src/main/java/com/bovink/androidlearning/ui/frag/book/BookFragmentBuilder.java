package com.bovink.androidlearning.ui.frag.book;

import com.bovink.androidlearning.di.ViewPagerFragmentScoped;
import com.bovink.androidlearning.ui.frag.comic.ComicFragment;
import com.bovink.androidlearning.ui.frag.comic.ComicModule;
import com.bovink.androidlearning.ui.frag.magzine.MagazineFragment;
import com.bovink.androidlearning.ui.frag.magzine.MagazineModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author fox
 * @since 2018/04/02
 */

@Module
public abstract class BookFragmentBuilder {

    @ViewPagerFragmentScoped
    @ContributesAndroidInjector(modules = MagazineModule.class)
    abstract MagazineFragment bindMagazineFragment();

    @ViewPagerFragmentScoped
    @ContributesAndroidInjector(modules = ComicModule.class)
    abstract ComicFragment bindComicFragment();
}
