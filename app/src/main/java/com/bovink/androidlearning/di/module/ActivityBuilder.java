package com.bovink.androidlearning.di.module;


import com.bovink.androidlearning.activity.main.MainActivity;
import com.bovink.androidlearning.activity.main.MainModule;
import com.bovink.androidlearning.activity.second.MultiFragActivity;
import com.bovink.androidlearning.activity.second.MultiFragFragmentBuilder;
import com.bovink.androidlearning.activity.second.MultiFragModule;
import com.bovink.androidlearning.di.ActivityScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author fox
 * @since 2017/09/21
 */
@Module
public abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {MultiFragModule.class, MultiFragFragmentBuilder.class})
    abstract MultiFragActivity bindMultiFragActivity();
}
