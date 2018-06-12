package com.anarchy.classifyview.sample.normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
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
public class NormalFragment extends BaseFragment{
    private ClassifyView mClassifyView;
    private final String TAG="ClassifyView";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.normal,container,false);
        mClassifyView = (ClassifyView) view.findViewById(R.id.classify_view);
        mClassifyView.setAdapter(new MyAdapter(DataGenerate.generateBean()));
        mClassifyView.addDragListener(new ClassifyView.DragListener() {
            @Override
            public void onDragStart(ViewGroup parent, View selectedView, float startX, float startY, int region) {
                Log.d(TAG,"-----onDragStart------");
            }

            @Override
            public void onDragStartAnimationEnd(ViewGroup parent, View selectedView, int region) {

            }

            @Override
            public void onDragEnd(ViewGroup parent, int region) {

                Log.d(TAG,"-----onDragEnd------");
            }

            @Override
            public void onDragRelease(ViewGroup parent, float releaseX, float releaseY, int region) {

            }

            @Override
            public void onMove(ViewGroup parent, float touchX, float touchY, int region) {

            }
        });
        mClassifyView.setDebugAble(true);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
