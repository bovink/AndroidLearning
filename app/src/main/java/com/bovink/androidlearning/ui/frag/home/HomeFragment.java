package com.bovink.androidlearning.ui.frag.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;

/**
 * @author fox
 * @since 2018/04/02
 */

public class HomeFragment extends Fragment {

    HomeViewFragment mFragment;

    HomePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_home, container, false);

        mPresenter = new HomePresenter();
        mFragment = HomeViewFragment.newInstance(mPresenter);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_home_content, mFragment)
                .commit();

        return root;
    }
}
