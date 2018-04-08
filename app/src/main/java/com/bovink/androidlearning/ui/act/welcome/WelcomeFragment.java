package com.bovink.androidlearning.ui.act.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.ui.act.main.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/04/02
 */

public class WelcomeFragment extends Fragment implements WelcomeContract.View {

    WelcomeContract.Presenter mPresenter;

    Context mContext;

    public static WelcomeFragment newInstance(WelcomeContract.Presenter presenter) {

        WelcomeFragment fragment = new WelcomeFragment();
        fragment.mPresenter = presenter;

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_welcome, container, false);
        ButterKnife.bind(this, root);

        mContext = getContext();

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mPresenter.bindView(this);
    }

    @Override
    public void showMainActivity() {

        Intent intent = new Intent(mContext, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_show_main)
    void showMain() {

        showMainActivity();
    }
}
