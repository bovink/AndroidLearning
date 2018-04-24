package com.bovink.androidlearning.ui.frag.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

/**
 * @author fox
 * @since 2018/04/02
 */

public class HomeFragment extends DaggerFragment {

    @Inject
    HomeViewFragment mFragment;

    @Inject
    HomePresenter mPresenter;

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_home, container, false);
        ButterKnife.bind(this, root);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_home_content, mFragment)
                .commit();

        return root;
    }
}
