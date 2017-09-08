package com.sh.sculuo.libluo.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.sh.sculuo.libluo.App;


public class AppHelper {

    public static String DEVICE_ID;
    public static long exitTime = 0;
    public static long beepTime = 0;
    public static String VERSION_NAME;

    /**
     * 获取设备ID
     *
     * @return
     */
    public static String getDeviceId() {
        if (TextUtils.isEmpty(DEVICE_ID)) {
            TelephonyManager tm = (TelephonyManager) App.context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            DEVICE_ID = tm.getDeviceId();
        }
        return DEVICE_ID;
    }

    /**
     * 获取App版本名
     *
     * @return
     */
    public static String getAppVersion() {
        if (TextUtils.isEmpty(VERSION_NAME)) {
            PackageManager manager = App.context.getPackageManager();
            try {
                PackageInfo info = manager.getPackageInfo(
                        App.context.getPackageName(), 0);
                VERSION_NAME = info.versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return VERSION_NAME;
    }

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) App.context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }


}
