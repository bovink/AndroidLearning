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
import com.bovink.androidlearning.ui.act.home.MultiFragActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MainFragment extends Fragment implements MainContract.View {

    @Inject
    MainContract.Presenter mPresenter;

    @Inject
    Context mContext;

    @Inject
    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_main, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mPresenter.bindView(this);
    }

    @Override
    public void showMultiFragActivity() {

        Intent intent = new Intent(mContext, MultiFragActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_multifrag)
    void clickMultiFrag() {

        showMultiFragActivity();
    }
}
