package com.sh.sculuo.libluo.util;

import android.util.Log;

import com.sh.sculuo.libluo.Testing;

/**
 * Created by luoxiaocheng on 2017/5/19.
 */

public class LogUtil {
    public static void e(String msg) {
        e("LogUtil", msg);
    }

    public static void e(String tag, String msg) {
        if (Testing.isTesting)
            Log.e(tag, msg);
    }

    public static void d(String tag, String s) {
        if (Testing.isTesting)
            Log.d(tag, s);
    }

    public static void w(String tag, String s, Exception ex) {
        if (Testing.isTesting)
            Log.w(tag, s, ex);
    }

    public static void v(String focus, String s) {
        if (Testing.isTesting)
            Log.d(focus, s);
    }
}
