package com.bovink.androidlearning.frag.b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * @author fox
 * @since 2018/04/02
 */

public class TestBFragment extends DaggerFragment {

    @Inject
    TestBViewFragment mFragment;

    @Inject
    TestBPresenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_testb, container, false);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_testb_content, mFragment)
                .commit();

        return root;
    }
}
