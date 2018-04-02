package com.bovink.androidlearning.activity.main;

import com.bovink.androidlearning.di.ActivityScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@ActivityScoped
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void bindView(MainContract.View view) {

        mView = view;
    }
}
