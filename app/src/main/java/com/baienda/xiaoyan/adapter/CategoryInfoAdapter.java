package com.baienda.xiaoyan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.recyclerview.CommonAdapter;
import com.baienda.xiaoyan.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class CategoryInfoAdapter extends CommonAdapter {
    public CategoryInfoAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, Object o, int position) {

    }

    @Override
    public void onViewHolderCreated(ViewHolder holder, View itemView) {
        super.onViewHolderCreated(holder, itemView);
        final ImageView image = holder.getView(R.id.iv_image);
        image.setColorFilter(mContext.getResources().getColor(R.color.transparent_black));
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        image.setColorFilter(Color.TRANSPARENT);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.e("======", "点击了");
                        image.setColorFilter(mContext.getResources().getColor(R.color.transparent_black));
                        return false;
                    case MotionEvent.ACTION_CANCEL:
                        image.setColorFilter(mContext.getResources().getColor(R.color.transparent_black));
                        return false;
                }
                return false;
            }
        });
    }
}
