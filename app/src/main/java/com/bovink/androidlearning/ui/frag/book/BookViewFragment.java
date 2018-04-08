package com.bovink.androidlearning.ui.frag.book;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.R;
import com.bovink.androidlearning.ui.frag.comic.ComicFragment;
import com.bovink.androidlearning.ui.frag.magzine.MagazineFragment;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fox
 * @since 2018/04/02
 */

public class BookViewFragment extends Fragment implements BookContract.View {

    private static final String MAGAZINE = MagazineFragment.class.getName();

    private static final String COMIC = ComicFragment.class.getName();

    Context mContext;

    BookContract.Presenter mPresenter;

    public static BookViewFragment newInstance(BookContract.Presenter presenter) {

        BookViewFragment fragment = new BookViewFragment();
        fragment.mPresenter = presenter;

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_book_view, container, false);
        ButterKnife.bind(this, root);

        mContext = getContext();

        showFragment(MAGAZINE, R.id.fl_content);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.bindView(this);
    }


    @OnClick(R.id.tv_magazine)
    void showMagazine() {

        showFragment(MAGAZINE, R.id.fl_content);
    }

    @OnClick(R.id.tv_comic)
    void showComic() {

        showFragment(COMIC, R.id.fl_content);
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
