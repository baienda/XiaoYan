package com.baienda.xiaoyan.adapter;

import android.content.Context;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.RVBaseAdapter;
import com.baienda.xiaoyan.recyclerview.ViewHolder;

import java.util.List;

/**
 * Created by Serenade on 2017/8/11.
 */

public class HotCoursesAdapter extends RVBaseAdapter {
    public HotCoursesAdapter(Context mContext, List mData) {
        super(mContext, mData);
    }

    @Override
    public int setLayout() {
        return R.layout.item_hot_courses;
    }

    @Override
    public void doInOnBindViewHolder(ViewHolder holder, int position) {

    }
}
