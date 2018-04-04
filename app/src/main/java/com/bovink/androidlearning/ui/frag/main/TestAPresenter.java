package com.bovink.androidlearning.ui.frag.main;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class TestAPresenter implements TestAContract.Presenter {

    private TestAContract.View mView;

    @Inject
    public TestAPresenter() {
    }

    @Override
    public void bindView(TestAContract.View view) {

        mView = view;
    }
}