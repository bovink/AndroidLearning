package com.bovink.androidlearning.databinding.layoutdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.IncludeActBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/14
 */

public class IncludeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IncludeActBinding binding = IncludeActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person = new Person();
        person.setName("super man");
        person.setSex("male");

        binding.setPerson(person);
    }
}
