package com.bovink.androidlearning.databinding.generatebinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.GenerateViewActBinding;

/**
 * @author fox
 * @since 2018/03/14
 */

public class GenerateViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GenerateViewActBinding binding = GenerateViewActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
