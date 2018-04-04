package com.bovink.androidlearning.ui.frag.book;


/**
 * @author fox
 * @since 2018/04/02
 */

public class BookPresenter implements BookContract.Presenter {

    private BookContract.View mView;

    public BookPresenter() {
    }

    @Override
    public void bindView(BookContract.View view) {

        mView = view;
    }
}
