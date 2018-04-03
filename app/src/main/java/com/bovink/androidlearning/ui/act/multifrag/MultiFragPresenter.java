package com.bovink.androidlearning.ui.act.multifrag;

import com.bovink.androidlearning.di.ActivityScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@ActivityScoped
public class MultiFragPresenter implements MultiFragContract.Presenter {

    private MultiFragContract.View mView;

    @Inject
    public MultiFragPresenter() {
    }

    @Override
    public void bindView(MultiFragContract.View view) {

        mView = view;
    }
}
