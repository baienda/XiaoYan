package com.baienda.xiaoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.RVBaseAdapter;
import com.baienda.xiaoyan.recyclerview.ViewHolder;

import java.util.List;

/**
 * Created by Serenade on 2017/8/11.
 */

public class ActivityListAdapter extends RVBaseAdapter {
    public ActivityListAdapter(Context mContext, List mData) {
        super(mContext, mData);
    }

    @Override
    public int setLayout() {
        return R.layout.item_activity_list;
    }

    @Override
    public void doInOnBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
