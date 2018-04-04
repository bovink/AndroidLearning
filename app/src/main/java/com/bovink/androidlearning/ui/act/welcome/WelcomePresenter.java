package com.bovink.androidlearning.ui.act.welcome;

import com.bovink.androidlearning.di.ActivityScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@ActivityScoped
public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View mView;

    @Inject
    public WelcomePresenter() {
    }

    @Override
    public void bindView(WelcomeContract.View view) {

        mView = view;
    }
}
