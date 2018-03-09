package com.bovink.androidlearning.databinding.layoutbinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bovink.androidlearning.databinding.FirstActBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/08
 */

public class LayoutBindActivity extends AppCompatActivity {
    Person person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirstActBinding binding = FirstActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        person = new Person();
        person.setName("lilei");
        person.setSex("male");

        binding.setPerson(person);

        binding.clickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                person.setName("hanmeimei");
                person.setSex("female");
            }
        });
    }
}
