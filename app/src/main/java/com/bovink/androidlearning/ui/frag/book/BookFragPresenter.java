package com.bovink.androidlearning.ui.frag.book;

import com.bovink.androidlearning.di.FragmentScoped;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

@FragmentScoped
public class BookFragPresenter implements BookFragContract.Presenter {

    private BookFragContract.View mView;

    @Inject
    public BookFragPresenter() {
    }

    @Override
    public void bindView(BookFragContract.View view) {

        mView = view;
    }
}
