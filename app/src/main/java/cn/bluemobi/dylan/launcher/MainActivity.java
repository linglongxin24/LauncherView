package cn.bluemobi.dylan.launcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bluemobi.dylan.LauncherView;

public class MainActivity extends AppCompatActivity {
    private LauncherView mLauncherView;
    private final String TAG = "LauncherView";
    private MyAdapter baseSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        mLauncherView = (LauncherView) findViewById(R.id.launcher_view);
        List<List<Bean>> mData = initData();
        baseSimpleAdapter = new MyAdapter(mData);
        mLauncherView.setAdapter(baseSimpleAdapter);
    }

    /**
     * 初始化数据
     *
     * @return 数据集合
     */
    public List<List<Bean>> initData() {
        List<List<Bean>> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<Bean> inner = new ArrayList<>();
            if (i > 10) {
                int c = (int) (Math.random() * 15 + 1);
                for (int j = 0; j < c; j++) {
                    Bean e = new Bean();
                    e.setFolder(true);
                    e.setName("应用" + i + "-" + j);
                    e.setFolderName("文件夹" + i);
                    inner.add(e);
                }
            } else {
                Bean b = new Bean();
                b.setFolder(false);
                b.setName("应用" + i);
                inner.add(b);
            }
            data.add(inner);
        }
        return data;
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
