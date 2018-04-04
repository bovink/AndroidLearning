package com.bovink.androidlearning.ui.act.main;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter() {
    }

    @Override
    public void bindView(MainContract.View view) {

        mView = view;
    }
}
