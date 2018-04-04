package com.bovink.androidlearning.ui.frag.mine;

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

public class MineFragment extends Fragment {

    MineViewFragment mFragment;

    MinePresenter mPresenter;

    public static MineFragment newInstance() {

        return new MineFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_mine, container, false);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_mine_content, mFragment)
                .commit();

        return root;
    }
}
