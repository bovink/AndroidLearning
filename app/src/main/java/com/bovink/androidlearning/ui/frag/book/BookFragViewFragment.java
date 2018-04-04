package com.bovink.androidlearning.ui.frag.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

public class BookFragViewFragment extends Fragment implements BookFragContract.View {

    @Inject
    BookFragContract.Presenter mPresenter;

    @Inject
    public BookFragViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = null;
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.bindView(this);
    }
}
