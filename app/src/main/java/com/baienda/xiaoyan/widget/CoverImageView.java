package com.baienda.xiaoyan.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Serenade on 2017/8/11.
 */

public class CoverImageView extends ImageView {
    private String mContent = "";
    private Context mContext;
    private int mViewHeight;
    private int mViewWidth;
    private Paint mPaint;

    public CoverImageView(Context context) {
        super(context);
        init(context);
    }

    public CoverImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CoverImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }


    public void setText(String s) {
        mContent = s;
    }

    public String getText() {
        return mContent;
    }

    public void setTextSize(float textSize) {
        mPaint.setTextSize(textSize);
    }

    public void setTextColor(int color) {
        mPaint.setColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewHeight = getMeasuredHeight();
        mViewWidth = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        int baseLineY = (int) (mViewHeight / 2 - top / 2 - bottom / 2);//基线中间点的y轴计算公式
        canvas.drawText(mContent, mViewWidth / 2, baseLineY, mPaint);
    }
}
