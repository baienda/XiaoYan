package com.baienda.xiaoyan.widget;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Serenade on 2017/8/11.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

    @Override
    public ImageView createImageView(Context context) {
        CoverImageView imageView = new CoverImageView(context);
        imageView.setTextSize(50);
        imageView.setTextColor(Color.WHITE);
        imageView.setText("#哈哈哈哈");
        imageView.setColorFilter(Color.parseColor("#AA222222"));
        return imageView;
    }

}
