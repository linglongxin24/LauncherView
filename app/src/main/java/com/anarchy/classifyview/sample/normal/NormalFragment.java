package com.anarchy.classifyview.sample.normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.anarchy.classify.ClassifyView;
import com.anarchy.classifyview.R;
import com.anarchy.classifyview.core.BaseFragment;
import com.anarchy.classifyview.core.MyAdapter;
import com.anarchy.classifyview.utils.DataGenerate;

/**
 * <p/>
 * Date: 16/6/12 09:51
 * Author: rsshinide38@163.com
 * <p/>
 */
public class NormalFragment extends BaseFragment {
    private ClassifyView mClassifyView;
    private final String TAG = "ClassifyView";
    private MyAdapter baseSimpleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.normal, container, false);
        mClassifyView = (ClassifyView) view.findViewById(R.id.classify_view);
        baseSimpleAdapter = new MyAdapter(DataGenerate.generateBean());
        mClassifyView.setAdapter(baseSimpleAdapter);
        mClassifyView.addDragListener(new ClassifyView.DragListener() {
            @Override
            public void onLongPress() {
            }

            @Override
            public void onDragStart(ViewGroup parent, View selectedView, float startX, float startY, int region) {
                Log.d(TAG, "-----onDragStart------");
                baseSimpleAdapter.setLongPress(true);
                baseSimpleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onDragStartAnimationEnd(ViewGroup parent, View selectedView, int region) {

            }

            @Override
            public void onDragEnd(ViewGroup parent, int region) {

                baseSimpleAdapter.notifyDataSetChanged();
                Log.d(TAG, "-----onDragEnd------");
            }

            @Override
            public void onDragRelease(ViewGroup parent, float releaseX, float releaseY, int region) {

            }

            @Override
            public void onMove(ViewGroup parent, float touchX, float touchY, int region) {

            }
        });
        mClassifyView.setDebugAble(true);
        mClassifyView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_BACK){
                    if (baseSimpleAdapter.isLongPress()) {
                        baseSimpleAdapter.setLongPress(false);
                        baseSimpleAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
