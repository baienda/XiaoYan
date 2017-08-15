package com.baienda.xiaoyan.adapter;

import android.content.Context;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.CommonAdapter;
import com.baienda.xiaoyan.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class AddressListAdapter extends CommonAdapter {
    public AddressListAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, Object o, int position) {
        switch (position) {
            case 0:
                holder.setText(R.id.tv_username, "新的朋友");
                break;
            case 1:
                holder.setText(R.id.tv_username, "添加好友");
                break;
            case 2:
                holder.setText(R.id.tv_username, "群组");
                break;
            default:
                holder.setText(R.id.tv_username, "郝亮" + mDatas.get(position) + "号");
                break;
        }
    }
}
