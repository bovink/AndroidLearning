package com.bovink.androidlearning.di.component;

import android.app.Application;

import com.bovink.androidlearning.base.MyApplication;
import com.bovink.androidlearning.di.module.ActivityBuilder;
import com.bovink.androidlearning.di.module.ApplicationModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author fox
 * @since 2017/09/21
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        ApplicationModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(MyApplication application);
}
