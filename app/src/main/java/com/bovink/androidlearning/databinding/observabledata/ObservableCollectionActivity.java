package com.bovink.androidlearning.databinding.observabledata;

import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.ObservableCollectionActBinding;

/**
 * @author fox
 * @since 2018/03/14
 */

public class ObservableCollectionActivity extends AppCompatActivity {

    ObservableArrayMap<String, Object> user = new ObservableArrayMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ObservableCollectionActBinding binding = ObservableCollectionActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user.put("name", "bruce");
        user.put("hobby", "hero");
        user.put("age", 35);

        binding.setUser(user);

        EventHandler handler = new EventHandler();
        binding.setHandler(handler);
    }

    public class EventHandler {

        public void changeContent() {

            user.put("hobby", "make money");
            user.put("age", 38);
        }
    }
}
