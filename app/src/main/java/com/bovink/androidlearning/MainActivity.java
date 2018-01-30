package com.bovink.androidlearning;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {
    List<Map<String, String>> mapList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapList = generateList();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                mapList,
                R.layout.item_list_activity,
                new String[]{"name"},
                new int[]{R.id.tv_name}
        );

        setListAdapter(simpleAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String test = mapList.get(position).get("name");

        try {
            Class clazz = Class.forName("com.bovink.androidlearning.butterknife." + test);
            Intent intent = new Intent(this, clazz);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Map<String, String>> generateList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "BindAnimActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindArrayActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindBitmapActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindBoolActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindColorActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindDimenActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindDrawableActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindFloatActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindFontActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindIntActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindStringActivity");
        mapList.add(map);

        return mapList;
    }

}
