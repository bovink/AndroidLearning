package com.bovink.androidlearning.activity.second;

import com.bovink.androidlearning.di.ActivityScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@ActivityScoped
public class SecondPresenter implements SecondContract.Presenter {

    private SecondContract.View mView;

    @Inject
    public SecondPresenter() {
    }

    @Override
    public void bindView(SecondContract.View view) {

        mView = view;
    }
}
