package com.bovink.androidlearning.ui.act.welcome;

/**
 * @author fox
 * @since 2018/04/02
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View mView;

    public WelcomePresenter() {
    }

    @Override
    public void bindView(WelcomeContract.View view) {

        mView = view;
    }
}
