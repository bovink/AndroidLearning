package com.bovink.androidlearning.databinding.layoutbinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.R;
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

        // 第一种绑定方式
        FirstActBinding binding = DataBindingUtil.setContentView(this, R.layout.first_act);

        // 第二种绑定方式
//        FirstActBinding binding = FirstActBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        person = new Person();
        person.setName("lilei");
        person.setSex("male");

        binding.setPerson(person);

    }
}
