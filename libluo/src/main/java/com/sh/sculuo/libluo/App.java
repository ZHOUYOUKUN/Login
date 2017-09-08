package com.sh.sculuo.libluo;

import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.sh.sculuo.libluo.config.ConfigApp;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.PlatformConfig;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by luoxiaocheng on 2017/5/20.
 */

public class App extends MultiDexApplication {
    public static App context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Realm.init(this);
        String packageName = getPackageName();
        String[] split = packageName.split("\\.");
        String dataName = split[split.length - 1];
        RealmConfiguration config = new  RealmConfiguration.Builder()
                .name(dataName+".realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        CrashReport.initCrashReport(this, ConfigApp.bugly_appid, Testing.isTesting);
        Fresco.initialize(this);
        ButterKnife.setDebug(Testing.isTesting);
        PlatformConfig.setWeixin(ConfigApp.wechat_appid, ConfigApp.wechat_appsecret);
        PlatformConfig.setQQZone(ConfigApp.qq_appid, ConfigApp.qq_appsecret);
    }
}
