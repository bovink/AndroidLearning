package com.bovink.androidlearning.ui.frag.b;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class TestBPresenter implements TestBContract.Presenter {

    private TestBContract.View mView;

    @Inject
    public TestBPresenter() {
    }

    @Override
    public void bindView(TestBContract.View view) {

        mView = view;
    }
}
