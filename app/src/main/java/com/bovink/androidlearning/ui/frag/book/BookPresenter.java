package com.bovink.androidlearning.ui.frag.book;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class BookPresenter implements BookContract.Presenter {

    private BookContract.View mView;

    @Inject
    public BookPresenter() {
    }

    @Override
    public void bindView(BookContract.View view) {

        mView = view;
    }
}
