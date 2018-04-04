package com.bovink.androidlearning.ui.frag.magzine;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MagazinePresenter implements MagazineContract.Presenter {

    private MagazineContract.View mView;

    public MagazinePresenter() {
    }

    @Override
    public void bindView(MagazineContract.View view) {

        mView = view;
    }
}
