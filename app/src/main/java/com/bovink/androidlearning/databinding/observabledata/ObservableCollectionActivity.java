package com.bovink.androidlearning.databinding.observabledata;

import android.databinding.ObservableArrayList;
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

    ObservableArrayList<Object> user2 = new ObservableArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ObservableCollectionActBinding binding = ObservableCollectionActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user.put("name", "bruce");
        user.put("hobby", "hero");
        user.put("age", 35);

        binding.setUser1(user);

        EventHandler handler = new EventHandler();
        binding.setHandler(handler);

        user2.add("lilei");
        user2.add("actor");
        user2.add(23);
        binding.setUser2(user2);

    }

    public class EventHandler {

        public void changeUser1() {

            user.put("hobby", "make money");
            user.put("age", 38);
        }

        public void changeUser2() {

            user2.remove(1);
            user2.remove(1);
            user2.add("writer");
            user2.add(25);
        }
    }
}
