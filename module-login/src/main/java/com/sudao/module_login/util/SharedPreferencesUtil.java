package com.sudao.module_login.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by guying on 16/3/17.
 */
public class SharedPreferencesUtil {

    private static SharedPreferencesUtil instance;

    private SharedPreferences.Editor editor;

    private SharedPreferences settings;

    public static SharedPreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtil(context.getApplicationContext());
        }
        return instance;
    }

    public SharedPreferencesUtil(Context context) {
        settings = context.getSharedPreferences("config", 0);
        editor = settings.edit();
    }

    /**
     * 保存数据.
     */
    public void saveTempData(HashMap<String, String> param) {
        Iterator<Map.Entry<String, String>> iter = param.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();

            String value = "";

            if (entry.getValue() != null) {
                value = entry.getValue().toString();
            }

            editor.putString(entry.getKey().toString(), value);
        }
        editor.commit();
    }

    /**
     * 保存数据.
     */
    public void saveTempData(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 读取数据.
     */
    public String readTempData(String key) {
        return settings.getString(key, "");
    }

}
