package com.baienda.xiaoyan.utils.img;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Serenade on 2017/8/14.
 */

public class GlideUtils {
    public static final String DEFAULT_DISK_CACHE_DIR = "image_cache";

    public void load(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .into(view);
    }

    public void load(Context context, String url, int placeholder, ImageView view) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .into(view);
    }

    public void load(Context context, String url, int placeholder, int error, ImageView view) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .error(error)
                .into(view);
    }
}
