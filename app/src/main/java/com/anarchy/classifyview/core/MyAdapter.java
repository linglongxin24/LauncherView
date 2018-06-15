package com.anarchy.classifyview.core;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anarchy.classify.simple.SimpleAdapter;
import com.anarchy.classifyview.R;

import java.util.Collections;
import java.util.List;

/**
 * <p/>
 * Date: 16/6/7 16:40
 * Author: rsshinide38@163.com
 * <p/>
 */
public class MyAdapter extends SimpleAdapter<Bean, MyAdapter.ViewHolder> {
    private String Tag="LauncherRecyclerView";
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
        if (getSubItemCount(mainPosition) == 1) {
            tv_name.setText("应用" + mainPosition);
        } else {
            if (subPosition == -1) {
                tv_name.setText("文件夹" + mainPosition);
            } else {
                tv_name.setText("应用" + mainPosition + "-" + (subPosition + 1));
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
    protected void onDragStart(ViewHolder viewHolder, int parentIndex, int index) {
        super.onDragStart(viewHolder, parentIndex, index);
        setLongPress(true);
        notifyDataSetChanged();
    }

    @Override
    protected void onDragAnimationEnd(ViewHolder viewHolder, int parentIndex, int index) {
        super.onDragAnimationEnd(viewHolder, parentIndex, index);
//        notifyDataSetChanged();
    }

    @Override
    protected void onMove(int selectedPosition, int targetPosition) {
//        super.onMove(selectedPosition, targetPosition);
        Log.d(Tag,"--onMove--selectedPosition="+selectedPosition+"targetPosition="+targetPosition);
    }

    @Override
    protected void onMerged(int selectedPosition, int targetPosition) {
        super.onMerged(selectedPosition, targetPosition);
        Log.d(Tag,"--onMerged--selectedPosition="+selectedPosition+"targetPosition="+targetPosition);
    }

    @Override
    protected void onSubMove(List<Bean> beans, int selectedPosition, int targetPosition) {
        super.onSubMove(beans, selectedPosition, targetPosition);
        Log.d(Tag,"--onSubMove--selectedPosition="+selectedPosition+"targetPosition="+targetPosition);
    }

    @Override
    protected void onSubDialogShow(Dialog dialog, int parentPosition) {
        super.onSubDialogShow(dialog, parentPosition);
        final EditText et_folder = (EditText) dialog.findViewById(com.anarchy.classify.R.id.et_folder);
        et_folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_folder.setFocusable(true);
                et_folder.setFocusableInTouchMode(true);
                et_folder.requestFocus();
            }
        });
        et_folder.setText("文件夹1");
        et_folder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                et_folder.setFocusable(false);
                et_folder.setFocusableInTouchMode(false);
            }
        });
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
