package com.bovink.androidlearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fox
 * @since 2018/03/01
 */

public class TextFragment extends Fragment {

    private String title;

    @BindView(R.id.tv_title)
    TextView titleTextView;

    public static TextFragment newInstance(String title) {

        TextFragment fragment = new TextFragment();
        fragment.title = title;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        ButterKnife.bind(this, root);

        titleTextView.setText(title);
        return root;
    }
}
