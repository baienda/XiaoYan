package com.baienda.xiaoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.mvp.view.activity.CategoryInfoActivity;
import com.baienda.xiaoyan.recyclerview.CommonAdapter;
import com.baienda.xiaoyan.recyclerview.base.ViewHolder;
import com.baienda.xiaoyan.utils.system.SystemUtil;

import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class HotCategoriesAdapter extends CommonAdapter {
    public HotCategoriesAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, Object o, int position) {
        holder.setText(R.id.tv_title, "# 生活" + position);
        if (position % 2 == 0) {
            if (position == mDatas.size() - 2)
                holder.itemView.setPadding(0, 0, 5, 0);
            else
                holder.itemView.setPadding(0, 0, 5, 10);

        } else {
            if (position == mDatas.size() - 1)
                holder.itemView.setPadding(5, 0, 0, 0);
            else
                holder.itemView.setPadding(5, 0, 0, 10);
        }
    }

    @Override
    public void onViewHolderCreated(final ViewHolder holder, View itemView) {
        super.onViewHolderCreated(holder, itemView);

        //给单个item设置宽高
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        int n = (int) (SystemUtil.getScreenWidth(mContext) / 2);
        params.width = n;
        params.height = n;

        //默认给ImageView添加蒙版
        final ImageView image = holder.getView(R.id.iv_image);
        image.setColorFilter(mContext.getResources().getColor(R.color.transparent_black));

        //给覆盖的TextView设置触摸事件来控制ImageView蒙版颜色
        holder.getView(R.id.tv_title).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        image.setColorFilter(Color.TRANSPARENT);
                        return true;
                    case MotionEvent.ACTION_UP:
                        String title = ((TextView) holder.getView(R.id.tv_title)).getText().toString();
                        title = title.replace("# ", "");
                        Intent intent = new Intent(mContext, CategoryInfoActivity.class);
                        intent.putExtra("title", title);
                        mContext.startActivity(intent);
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
