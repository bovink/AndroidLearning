package com.bovink.androidlearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    /**
     * 包名
     */
    private String mPackageName;
    List<Map<String, String>> mapList;
    private ListView listView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        listView = findViewById(R.id.lv_activity);

        int type = getIntent().getIntExtra("type", 0);

        if (type == 1) {// 绑定资源

            mapList = generateResourceList();
            mPackageName = "com.bovink.androidlearning.databinding.layoutbinding.";
        } else if (type == 2) {// 绑定事件

            mapList = generateEventList();
            mPackageName = "com.bovink.androidlearning.databinding.layoutdetails.";
        } else if (type == 3) {// 绑定单个视图

            mapList = generateViewList();
            mPackageName = "com.bovink.androidlearning.databinding.expression.";
        } else if (type == 4) {// 绑定多个视图

            mapList = generateViewsList();
            mPackageName = "com.bovink.androidlearning.databinding.layoutdetails.";
        } else {// 选择绑定资源或是绑定事件

            mapList = generateBindList();
            mPackageName = "com.bovink.androidlearning.";
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                mapList,
                R.layout.list_item_activity,
                new String[]{"name"},
                new int[]{R.id.tv_name}
        );

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new MyOnItemClickListener());
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String activityName = mapList.get(position).get("name");
            if (activityName.contains(".")) {
                System.out.println("activityName = " + activityName);
                activityName = activityName.split("\\.")[0];
            }

            try {
                Class clazz = Class.forName(mPackageName + activityName);
                Intent intent = new Intent(mContext, clazz);
                if (activityName.equals("MainActivity")) {
                    intent.putExtra("type", position + 1);
                }
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 生成绑定列表
     */
    private List<Map<String, String>> generateBindList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "MainActivity.LayoutBinding");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "MainActivity.LayoutDetails");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "MainActivity.Expression");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "MainActivity.BindViews");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定资源列表
     */
    private List<Map<String, String>> generateResourceList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "LayoutBindActivity");
        mapList.add(map);
        map = new HashMap<>();
        map.put("name", "EventHandlerActivity");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定事件列表
     */
    private List<Map<String, String>> generateEventList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "ImportActivity");
        mapList.add(map);

        map = new HashMap<>();
        map.put("name", "CustomBindActivity");
        mapList.add(map);

        map = new HashMap<>();
        map.put("name", "IncludeActivity");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定单个视图列表
     */
    private List<Map<String, String>> generateViewList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "ExpressionActivity");
        mapList.add(map);

        return mapList;
    }

    /**
     * 生成绑定多个视图列表
     */
    private List<Map<String, String>> generateViewsList() {

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map;

        map = new HashMap<>();
        map.put("name", "BindViewsActivity");
        mapList.add(map);

        return mapList;
    }
}
