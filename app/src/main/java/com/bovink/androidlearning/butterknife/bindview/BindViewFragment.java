package com.bovink.androidlearning.butterknife.bindview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bovink.androidlearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fox
 * @since 2018/03/02
 */

public class BindViewFragment extends Fragment {

    @BindView(R.id.iv_test)
    ImageView testImageView;

    public static BindViewFragment newInstance() {
        return new BindViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bindview, container, false);

        ButterKnife.bind(this, root);

        testImageView.setImageResource(R.drawable.all);
        return root;
    }
}
