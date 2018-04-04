package com.bovink.androidlearning.ui.act.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.ui.frag.book.BookFragFragment;
import com.bovink.androidlearning.ui.frag.home.HomeFragment;
import com.bovink.androidlearning.ui.frag.mine.MineFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/04/02
 */

public class MainFragment extends Fragment implements MainContract.View {


    private static final String TESTA = HomeFragment.class.getName();

    private static final String TESTB = MineFragment.class.getName();

    private static final String BOOK = BookFragFragment.class.getName();

    @Inject
    Context mContext;

    @Inject
    MainContract.Presenter mPresenter;

    @Inject
    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_home, container, false);
        ButterKnife.bind(this, root);

        showFragment(TESTA, R.id.fl_frag_content);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mPresenter.bindView(this);
    }

    @OnClick(R.id.tv_testa)
    void showTestA() {

        showFragment(TESTA, R.id.fl_frag_content);
    }

    @OnClick(R.id.tv_testb)
    void showTestB() {

        showFragment(TESTB, R.id.fl_frag_content);
    }

    @OnClick(R.id.tv_book)
    void showBook() {

        showFragment(BOOK, R.id.fl_frag_content);
    }

    private void showFragment(String tag, int containerViewId) {

        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();

        // 隐藏所有Fragment
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        for (Fragment f : fragments) {
            beginTransaction.hide(f);
        }

        Fragment fragment = getChildFragmentManager().findFragmentByTag(tag);

        if (fragment == null) {// 如果Fragment不存在

            fragment = Fragment.instantiate(mContext, tag);
            beginTransaction.add(containerViewId, fragment, tag);
        } else {// 如果Fragment存在

            beginTransaction.show(fragment);
        }

        beginTransaction.commit();
    }

}
