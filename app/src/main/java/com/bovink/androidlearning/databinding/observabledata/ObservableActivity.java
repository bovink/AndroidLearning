package com.bovink.androidlearning.databinding.observabledata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.ObservableActBinding;

/**
 * @author fox
 * @since 2018/03/14
 */

public class ObservableActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ObservableActBinding binding = ObservableActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        EventHandler handler = new EventHandler();
        binding.setHandler(handler);

    }

    public class EventHandler {

        public void changeClass() {

        }
    }
}
