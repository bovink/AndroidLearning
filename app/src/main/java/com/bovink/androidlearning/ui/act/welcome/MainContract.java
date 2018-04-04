package com.bovink.androidlearning.ui.act.welcome;

import com.bovink.androidlearning.mvp.BasePresenter;
import com.bovink.androidlearning.mvp.BaseView;

/**
 * @author fox
 * @since 2018/04/02
 */

interface MainContract {

    interface View extends BaseView {

        /**
         * 显示包含多个Fragment的Activity
         */
        void showMultiFragActivity();
    }

    interface Presenter extends BasePresenter<View> {

    }
}
