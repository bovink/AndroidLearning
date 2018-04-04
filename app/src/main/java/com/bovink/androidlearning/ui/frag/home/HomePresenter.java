package com.bovink.androidlearning.ui.frag.home;

/**
 * @author fox
 * @since 2018/04/02
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    public HomePresenter() {
    }

    @Override
    public void bindView(HomeContract.View view) {

        mView = view;
    }
}
