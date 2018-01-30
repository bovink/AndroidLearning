package com.bovink.androidlearning;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, String>> mapList = generateList();


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
        System.out.println("position = " + position);
        super.onListItemClick(l, v, position, id);
    }

    private List<Map<String, String>> generateList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "BindAnim.class");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindAnim.class");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindAnim.class");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindAnim.class");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindAnim.class");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "BindAnim.class");
        mapList.add(map);
        return mapList;
    }

}
