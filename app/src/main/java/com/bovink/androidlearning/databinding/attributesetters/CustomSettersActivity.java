package com.bovink.androidlearning.databinding.attributesetters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.CustomSettersActBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/16
 */

public class CustomSettersActivity extends AppCompatActivity {

    CustomSettersActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = CustomSettersActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person1 = new Person();
        person1.setName("lilei");
        person1.setAge("16");

        binding.setPerson1(person1);

        EventHandler handler = new EventHandler();
        binding.setHandler(handler);
    }

    public class EventHandler {

        public void changeAge() {

            Person person1 = binding.getPerson1();
            person1.setAge("18");
        }
    }
}
