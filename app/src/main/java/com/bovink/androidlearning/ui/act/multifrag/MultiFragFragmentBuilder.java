package com.bovink.androidlearning.ui.act.multifrag;

import com.bovink.androidlearning.di.FragmentScoped;
import com.bovink.androidlearning.ui.frag.a.TestAFragment;
import com.bovink.androidlearning.ui.frag.a.TestAModule;
import com.bovink.androidlearning.ui.frag.b.TestBFragment;
import com.bovink.androidlearning.ui.frag.b.TestBModule;

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

}
