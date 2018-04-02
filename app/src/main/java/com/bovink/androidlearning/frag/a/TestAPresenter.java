package com.bovink.androidlearning.frag.a;

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
