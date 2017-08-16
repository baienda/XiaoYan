package com.baienda.xiaoyan.recyclerview.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;

/**
 * Created by Serenade on 2017/8/16.
 */

public class CategoryDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private Paint rectPaint;

    private Context mContext;

    public CategoryDecoration(Context mContext) {
        this.mContext = mContext;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setTextSize(50);
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);

        rectPaint = new Paint();
        rectPaint.setColor(mContext.getResources().getColor(R.color.gray));
        rectPaint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int childCount = parent.getChildCount();
        int itemCount = parent.getAdapter().getItemCount();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            if (position < itemCount - 1 && (position + 1) % 3 == 0) {
                int left = parent.getPaddingLeft();
                int right = parent.getWidth() - parent.getPaddingRight();
                int top = view.getBottom() + 1;
                int bottom = top + 100;
                c.drawRect(left, top, right, bottom, rectPaint);
                c.drawText("#", left, top + 75, mPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int itemCount = parent.getAdapter().getItemCount();
        int position = parent.getChildAdapterPosition(view);
        if (position < itemCount - 1 && (position + 1) % 3 == 0)
            outRect.bottom = 101;
        else
            outRect.bottom = 0;
    }
}
