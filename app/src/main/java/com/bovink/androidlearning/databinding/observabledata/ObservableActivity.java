package com.bovink.androidlearning.databinding.observabledata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.ObservableActBinding;
import com.bovink.androidlearning.model.Time;
import com.bovink.androidlearning.model.ViewModel;

/**
 * @author fox
 * @since 2018/03/14
 */

public class ObservableActivity extends AppCompatActivity {

    ViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ObservableActBinding binding = ObservableActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModel();
        viewModel.description.set("hello");

        Time time = new Time();
        time.setHour("99");
        viewModel.time.set(time);
        binding.setViewModel(viewModel);

        EventHandler handler = new EventHandler();
        binding.setHandler(handler);

    }

    public class EventHandler {

        public void changeClass() {

            // 测试观察域
            viewModel.description.set("right");
            // 测试观察对象
            Time time = new Time();
            time.setHour("88");
            viewModel.time.set(time);
        }
    }
}
