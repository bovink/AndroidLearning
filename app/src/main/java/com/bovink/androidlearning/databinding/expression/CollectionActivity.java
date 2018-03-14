package com.bovink.androidlearning.databinding.expression;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bovink.androidlearning.databinding.CollectionActBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fox
 * @since 2018/03/14
 */

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CollectionActBinding binding = CollectionActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<String> list = new ArrayList<>();
        list.add("jane");
        list.add("bruce");
        list.add("park");

        Map<String, String> map = new HashMap<>();
        map.put("bruce", "batman");
        map.put("park", "spiderman");

        int index = 1;
        String key = "park";

        binding.setList(list);
        binding.setMap(map);
        binding.setIndex(index);
        binding.setKey(key);
    }
}
