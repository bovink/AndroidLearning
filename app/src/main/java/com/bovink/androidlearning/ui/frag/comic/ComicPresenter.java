package com.bovink.androidlearning.ui.frag.comic;

import com.bovink.androidlearning.di.ViewPagerFragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@ViewPagerFragmentScoped
public class ComicPresenter implements ComicContract.Presenter {

    private ComicContract.View mView;

    @Inject
    public ComicPresenter() {
    }

    @Override
    public void bindView(ComicContract.View view) {

        mView = view;
    }
}
