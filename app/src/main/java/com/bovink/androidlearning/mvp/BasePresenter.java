package com.bovink.androidlearning.mvp;

/**
 * MVP基础Presenter接口
 *
 * @author bovink
 * @since 2017/9/19
 */
public interface BasePresenter<T> {

    /**
     * 绑定View接口
     * @param view
     */
    void bindView(T view);
}
