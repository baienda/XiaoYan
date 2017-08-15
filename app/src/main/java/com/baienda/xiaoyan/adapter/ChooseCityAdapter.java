package com.baienda.xiaoyan.adapter;

import android.content.Context;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.CommonAdapter;
import com.baienda.xiaoyan.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class ChooseCityAdapter extends CommonAdapter<String> {
    public ChooseCityAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv_city, s);
    }
}
