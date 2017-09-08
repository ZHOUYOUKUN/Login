package com.sh.sculuo.libluo.util;

import android.widget.Toast;

import com.sh.sculuo.libluo.App;

/**
 * Created by luoxiaocheng on 2017/5/20.
 */

public class ToastUtil {
    public static void toast(String msg) {
        Toast.makeText(App.context, msg, Toast.LENGTH_LONG).show();
    }

    public static void toast(int resultId) {
        Toast.makeText(App.context, resultId, Toast.LENGTH_LONG).show();
    }
}
