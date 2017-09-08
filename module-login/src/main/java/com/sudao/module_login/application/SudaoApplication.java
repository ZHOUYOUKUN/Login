package com.sudao.module_login.application;

import android.Manifest;
import android.app.Application;
import android.content.Context;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.utils.Log;

public class SudaoApplication extends Application {

    public static final String TAG = "SudaoApplication";

    public static Context mContext;

    public UMShareAPI umShareAPI;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initUM();
    }

    /**
     * 初始化友盟
     */
    private void initUM(){
        PlatformConfig.setWeixin("wx1c454479fad90d45", "6ce6ecc7d6f6841006392231c32bf470");
        PlatformConfig.setQQZone("1106384820", "Q5Hv1h3q5zQjKolC");
        umShareAPI=UMShareAPI.get(this);

}
}
