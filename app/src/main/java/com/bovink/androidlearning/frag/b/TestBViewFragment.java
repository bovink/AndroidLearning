package com.bovink.androidlearning.frag.b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

/**
 * @author fox
 * @since 2018/04/02
 */

public class TestBViewFragment extends Fragment implements TestBContract.View {

    @Inject
    TestBContract.Presenter mPresenter;

    @Inject
    public TestBViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_testb_view, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mPresenter.bindView(this);
    }
}
