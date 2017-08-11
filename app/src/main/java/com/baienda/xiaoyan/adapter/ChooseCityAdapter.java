package com.baienda.xiaoyan.adapter;

import android.content.Context;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.RVBaseAdapter;
import com.baienda.xiaoyan.recyclerview.ViewHolder;

import java.util.List;

/**
 * Created by Serenade on 2017/8/11.
 */

public class ChooseCityAdapter extends RVBaseAdapter<String> {
    public ChooseCityAdapter(Context mContext, List mData) {
        super(mContext, mData);
    }

    @Override
    public int setLayout() {
        return R.layout.item_choose_city;
    }

    @Override
    public void doInOnBindViewHolder(ViewHolder holder, int position) {
        holder.setText(R.id.tv_city,mData.get(position));
    }
}
