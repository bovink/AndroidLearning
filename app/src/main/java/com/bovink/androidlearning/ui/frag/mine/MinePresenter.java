package com.bovink.androidlearning.ui.frag.mine;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MinePresenter implements MineContract.Presenter {

    private MineContract.View mView;

    public MinePresenter() {
    }

    @Override
    public void bindView(MineContract.View view) {

        mView = view;
    }
}
