package com.bovink.androidlearning.databinding.layoutbinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.FirstActBinding;

/**
 * @author fox
 * @since 2018/03/08
 */

public class LayoutBindActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirstActBinding binding = FirstActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
