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
import com.bovink.androidlearning.ui.act.home.HomeActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/04/02
 */

public class WelcomeFragment extends Fragment implements WelcomeContract.View {

    @Inject
    WelcomeContract.Presenter mPresenter;

    @Inject
    Context mContext;

    @Inject
    public WelcomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_welcome, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mPresenter.bindView(this);
    }

    @Override
    public void showHomeActivity() {

        Intent intent = new Intent(mContext, HomeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_show_home)
    void showHome() {

        showHomeActivity();
    }
}
