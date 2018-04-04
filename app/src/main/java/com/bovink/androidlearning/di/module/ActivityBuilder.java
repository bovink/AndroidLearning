package com.bovink.androidlearning.di.module;


import com.bovink.androidlearning.ui.act.welcome.WelcomeActivity;
import com.bovink.androidlearning.ui.act.welcome.WelcomeModule;
import com.bovink.androidlearning.ui.act.main.MainActivity;
import com.bovink.androidlearning.ui.act.main.MainFragmentBuilder;
import com.bovink.androidlearning.ui.act.main.MainModule;
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
    @ContributesAndroidInjector(modules = WelcomeModule.class)
    abstract WelcomeActivity bindMainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainModule.class, MainFragmentBuilder.class})
    abstract MainActivity bindMultiFragActivity();
}
