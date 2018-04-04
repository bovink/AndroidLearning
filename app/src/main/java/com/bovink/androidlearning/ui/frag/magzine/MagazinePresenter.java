package com.bovink.androidlearning.ui.frag.magzine;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class MagazinePresenter implements MagazineContract.Presenter {

    private MagazineContract.View mView;

    @Inject
    public MagazinePresenter() {
    }

    @Override
    public void bindView(MagazineContract.View view) {

        mView = view;
    }
}
