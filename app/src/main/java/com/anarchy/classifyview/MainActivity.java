package com.anarchy.classifyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anarchy.classify.LauncherView;
import com.anarchy.classifyview.core.MyAdapter;
import com.anarchy.classifyview.utils.DataGenerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private LauncherView mLauncherView;
    private final String TAG = "ClassifyView";
    private MyAdapter baseSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        mLauncherView = (LauncherView) findViewById(R.id.classify_view);

        List<Map<String, Object>> dataList = initData();
        baseSimpleAdapter = new MyAdapter(DataGenerate.generateBean());
        mLauncherView.setAdapter(baseSimpleAdapter);
    }

    private List<Map<String, Object>> initData() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>(2);
            if (i <= 10) {
                //一般的应用
                map.put("isFolder", false);
                map.put("name", "应用" + i);
            } else {
                //含有子集应用的文件夹
                map.put("isFolder", true);
                List<Map<String, Object>> mapList = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    //一般的应用
                    Map<String, Object> stringObjectMap = new HashMap<>(2);
                    stringObjectMap.put("isFolder", false);
                    stringObjectMap.put("name", "应用" + i + j);
                }
                map.put("list", mapList);
            }
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onBackPressed() {
        if (baseSimpleAdapter.isLongPress()) {
            baseSimpleAdapter.setLongPress(false);
            baseSimpleAdapter.notifyDataSetChanged();
        } else {
            super.onBackPressed();
        }
    }
}
