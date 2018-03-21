package com.bovink.androidlearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.databinding.FragmentMainBinding;

/**
 * @author fox
 * @since 2018/03/21
 */

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {

        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMainBinding binding = FragmentMainBinding.inflate(inflater);
        return binding.getRoot();

    }
}
