package com.bovink.androidlearning.databinding.converter;

import android.databinding.BindingConversion;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.ConverterActBinding;

/**
 * @author fox
 * @since 2018/03/14
 */

public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConverterActBinding binding = ConverterActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @BindingConversion
    public static int convertStringToColor(String color) {

        return Color.parseColor(color);
    }
}
