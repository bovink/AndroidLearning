package com.bovink.androidlearning.ui.frag.comic;


/**
 * @author fox
 * @since 2018/04/02
 */

public class ComicPresenter implements ComicContract.Presenter {

    private ComicContract.View mView;

    public ComicPresenter() {
    }

    @Override
    public void bindView(ComicContract.View view) {

        mView = view;
    }
}
