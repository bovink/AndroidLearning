package com.bovink.androidlearning.databinding.layoutdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.ImportActBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/08
 */

public class ImportActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImportActBinding binding = ImportActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person = new Person();
        person.setName("lilei");
        person.setAdult(false);

        binding.setPerson(person);
    }
}
