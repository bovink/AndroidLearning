package com.bovink.androidlearning.activity.main;

import com.bovink.androidlearning.mvp.BasePresenter;
import com.bovink.androidlearning.mvp.BaseView;

/**
 * @author fox
 * @since 2018/04/02
 */

interface MainContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
