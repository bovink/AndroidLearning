package com.bovink.androidlearning.ui.frag.mine;

import com.bovink.androidlearning.mvp.BasePresenter;
import com.bovink.androidlearning.mvp.BaseView;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MineContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
