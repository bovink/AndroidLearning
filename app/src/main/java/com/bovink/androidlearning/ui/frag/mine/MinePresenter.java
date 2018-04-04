package com.bovink.androidlearning.ui.frag.mine;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class MinePresenter implements MineContract.Presenter {

    private MineContract.View mView;

    @Inject
    public MinePresenter() {
    }

    @Override
    public void bindView(MineContract.View view) {

        mView = view;
    }
}
