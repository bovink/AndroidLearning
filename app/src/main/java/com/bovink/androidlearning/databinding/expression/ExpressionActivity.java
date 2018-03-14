package com.bovink.androidlearning.databinding.expression;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.ExpressionActBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/14
 */

public class ExpressionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExpressionActBinding binding = ExpressionActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person1 = new Person();

        person1.setName("superman");

        Person person2 = new Person();

        person2.setName("batman");
        person2.setNickName("bruce");

        binding.setPerson1(person1);
        binding.setPerson2(person2);
    }
}
