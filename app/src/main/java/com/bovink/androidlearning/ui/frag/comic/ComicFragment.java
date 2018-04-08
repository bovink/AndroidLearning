package com.bovink.androidlearning.ui.frag.comic;

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

public class ComicFragment extends Fragment {

    ComicViewFragment mFragment;

    ComicPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_comic, container, false);

        mPresenter = new ComicPresenter();
        mFragment = ComicViewFragment.newInstance(mPresenter);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_comic_content, mFragment)
                .commit();

        return root;
    }
}
