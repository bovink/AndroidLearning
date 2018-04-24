package com.bovink.androidlearning.ui.frag.comic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author fox
 * @since 2018/04/02
 */

public class ComicViewFragment extends Fragment implements ComicContract.View {

    @Inject
    ComicContract.Presenter mPresenter;

    @Inject
    public ComicViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_comic_view, container, false);
        ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mPresenter.bindView(this);
    }
}
