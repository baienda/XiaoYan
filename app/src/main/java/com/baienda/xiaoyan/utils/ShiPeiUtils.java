package com.baienda.xiaoyan.utils;

import android.util.Log;

/**
 * Created by Serenade on 2017/8/17.
 */

public class ShiPeiUtils {
    public static void getDimenXML() {
        int width = 750;//屏幕宽度
        int height = 1334;//屏幕高度
        float screenInch = 4.7f;//屏幕尺寸
        //设备密度公式
        float density = (float) Math.sqrt(width * width + height * height) / screenInch / 160;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        for (int px = 0; px <= 1000; px++) {
            //像素值除以density
            String dp = px * 1.0f / density + "";
            //拼接成资源文件的内容，方便引用
            if (dp.indexOf(".") + 4 < dp.length()) {//保留3位小数
                dp = dp.substring(0, dp.indexOf(".") + 4);
            }
            stringBuilder.append("<dimen name=\"px").append(px + "").append("dp\">").append(dp).append("dp</dimen>\n");
        }
        stringBuilder.append("</resources>");
        Log.e("==========",stringBuilder.toString());
    }
}
