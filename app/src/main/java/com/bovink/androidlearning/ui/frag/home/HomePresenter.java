package com.bovink.androidlearning.ui.frag.home;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void bindView(HomeContract.View view) {

        mView = view;
    }
}
