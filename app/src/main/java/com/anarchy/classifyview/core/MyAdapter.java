package com.anarchy.classifyview.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.anarchy.classify.simple.SimpleAdapter;
import com.anarchy.classify.simple.widget.InsertAbleGridView;
import com.anarchy.classifyview.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * <p/>
 * Date: 16/6/7 16:40
 * Author: rsshinide38@163.com
 * <p/>
 */
public class MyAdapter extends SimpleAdapter<Bean, MyAdapter.ViewHolder> {
    private boolean isLongPress = false;

    public MyAdapter setLongPress(boolean longPress) {
        isLongPress = longPress;
        return this;
    }

    public boolean isLongPress() {
        return isLongPress;
    }

    public MyAdapter(List<List<Bean>> mData) {
        super(mData);
    }


    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample_vertical, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindSubViewHolder(final ViewHolder holder, int mainPosition, int subPosition) {
        bindData(holder, mainPosition, subPosition);
    }

    private void bindData(ViewHolder holder, final int mainPosition, final int subPosition) {
        final TextView tv_name = (TextView) holder.itemView.findViewById(R.id.tv_name);
        if(getSubItemCount(mainPosition)==1){
            tv_name.setText("应用"+mainPosition);
        }else{
            if(subPosition==-1){
                tv_name.setText("文件夹"+mainPosition);
            }else{
                tv_name.setText("应用"+mainPosition+"-"+(subPosition+1));
            }
        }

        final TextView tv_del = (TextView) holder.itemView.findViewById(R.id.tv_del);
        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tv_del.getContext(), "删除", Toast.LENGTH_SHORT).show();
            }
        });
        final TextView tv_2 = (TextView) holder.itemView.findViewById(R.id.tv_2);
        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tv_del.getContext(), "编辑", Toast.LENGTH_SHORT).show();
            }
        });
        final TextView tv3 = (TextView) holder.itemView.findViewById(R.id.tv3);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tv_del.getContext(), "信息", Toast.LENGTH_SHORT).show();
            }
        });
        final View view = holder.itemView.findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "parentIndex: " + mainPosition + "\nindex: " + subPosition, Toast.LENGTH_SHORT).show();
            }
        });

        if (isLongPress) {
            tv_del.setVisibility(View.VISIBLE);
            tv_2.setVisibility(View.VISIBLE);
            tv3.setVisibility(View.VISIBLE);
        } else {
            tv_del.setVisibility(View.GONE);
            tv_2.setVisibility(View.GONE);
            tv3.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onBindMainViewHolder(ViewHolder holder, int position) {
        bindData(holder, position, -1);
//        super.onBindMainViewHolder(holder, position);
    }

    @Override
    public View getView(ViewGroup parent, View convertView, int mainPosition, int subPosition) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inner, parent, false);
        }
        return convertView;
    }

    @Override
    protected void onItemClick(View view, int parentIndex, int index) {

//        Toast.makeText(view.getContext(), "parentIndex: " + parentIndex + "\nindex: " + index, Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder extends SimpleAdapter.ViewHolder {
        TextView tv_del;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_del = (TextView) itemView.findViewById(R.id.tv_del);
        }
    }

}
