package com.bovink.androidlearning.frag.a;

import com.bovink.androidlearning.mvp.BasePresenter;
import com.bovink.androidlearning.mvp.BaseView;

/**
 * @author fox
 * @since 2018/04/02
 */

interface TestAContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
