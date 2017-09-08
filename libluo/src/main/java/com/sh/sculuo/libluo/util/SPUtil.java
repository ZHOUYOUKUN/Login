package com.sh.sculuo.libluo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.sh.sculuo.libluo.App;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luoxiaocheng on 2017/5/22.
 */

public class SPUtil {

    public static void saveInt(String key, int value) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        cache.edit()
                .putInt(key, value)
                .commit();
    }

    public static void clear() {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        cache.edit().clear()
                .commit();
    }

    public static int getInt(String key) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        return cache.getInt(key, 0);
    }

    public static void saveString(String key, String value) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        cache.edit()
                .putString(key, value)
                .commit();
    }

    public static String getString(String key) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        return cache.getString(key, "");
    }

    public static void saveBoolean(String key, boolean value) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        cache.edit()
                .putBoolean(key, value)
                .commit();
    }

    public static boolean getBoolean(String key) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        return cache.getBoolean(key, false);
    }

    public static void saveFloat(String key, float value) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        cache.edit()
                .putFloat(key, value)
                .commit();
    }

    public static float getFloat(String key) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        return cache.getFloat(key, 0.0f);
    }

    public static void saveLong(String key, long value) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        cache.edit()
                .putLong(key, value)
                .commit();
    }

    public static long getLong(String key) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        return cache.getLong(key, 0l);
    }

    public static void saveObject(String key, Object value) {
        saveString(key, new Gson().toJson(value));
    }

    public static <O> O getObject(String key, Class<O> c) {
        String string = getString(key);
        if (TextUtils.isEmpty(string))
            return null;
        return new Gson().fromJson(string, c);
    }

    public static void saveSet(String key, String value) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        Set<String> set = cache.getStringSet(key, new HashSet<String>());
        set.add(value);
        cache.edit().putStringSet(key, set).commit();
    }

    public static Set<String> getSet(String key) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        Set<String> set = cache.getStringSet(key, new HashSet<String>());
        return set;
    }

    public static void saveSet(String key, Set<String> set) {
        SharedPreferences cache = App.context.getSharedPreferences("cache", Context.MODE_APPEND);
        Set<String> set1 = cache.getStringSet(key, new HashSet<String>());
        set1.addAll(set);
        cache.edit().putStringSet(key, set1).commit();
    }
}
