package com.baienda.xiaoyan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.RVBaseAdapter;
import com.baienda.xiaoyan.recyclerview.ViewHolder;
import com.baienda.xiaoyan.utils.system.SystemUtil;

import java.util.List;

/**
 * Created by Serenade on 2017/8/11.
 */

public class HotCategoriesAdapter extends RVBaseAdapter {


    public HotCategoriesAdapter(Context mContext, List mData) {
        super(mContext, mData);
    }

    @Override
    public void doInOnCreateViewHolder(View itemView, ViewGroup parent, int viewType) {
        super.doInOnCreateViewHolder(itemView, parent, viewType);
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        int n = (int) (SystemUtil.getScreenWidth(mContext) / 2 - 5);
        params.width = n;
        params.height = n;
    }

    @Override
    public void doInOnBindViewHolder(ViewHolder holder, int position) {
        holder.setText(R.id.tv_title, "#生活");
    }

    @Override
    public int setLayout() {
        return R.layout.item_hot_categories;
    }

}
