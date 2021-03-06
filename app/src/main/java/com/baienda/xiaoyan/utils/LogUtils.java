package com.baienda.xiaoyan.utils;

import android.util.Log;

/**
 * Created by Serenade on 2017/8/17.
 */

public class LogUtils {
    private static boolean debug = true;

    public static void e(String tag, String content) {
        if (debug) {
            Log.e(tag, content);
        }
    }

    public static void d(String tag, String content) {
        if (debug) {
            Log.d(tag, content);
        }
    }

    public static void i(String tag, String content) {
        if (debug) {
            Log.i(tag, content);
        }
    }

    public static void w(String tag, String content) {
        if (debug) {
            Log.w(tag, content);
        }
    }

    public static void v(String tag, String content) {
        if (debug) {
            Log.v(tag, content);
        }
    }
}
