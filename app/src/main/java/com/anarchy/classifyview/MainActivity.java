package com.anarchy.classifyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anarchy.classify.ClassifyView;
import com.anarchy.classifyview.core.MyAdapter;
import com.anarchy.classifyview.utils.DataGenerate;

public class MainActivity extends AppCompatActivity {
    private ClassifyView mClassifyView;
    private final String TAG = "ClassifyView";
    private MyAdapter baseSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        mClassifyView = (ClassifyView) findViewById(R.id.classify_view);
        baseSimpleAdapter = new MyAdapter(DataGenerate.generateBean());
        mClassifyView.setAdapter(baseSimpleAdapter);
    }

    @Override
    public void onBackPressed() {
        if(baseSimpleAdapter.isLongPress()){
            baseSimpleAdapter.setLongPress(false);
            baseSimpleAdapter.notifyDataSetChanged();
        }else{
            super.onBackPressed();
        }
    }
}
