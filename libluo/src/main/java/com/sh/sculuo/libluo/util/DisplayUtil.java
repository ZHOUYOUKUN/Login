package com.sh.sculuo.libluo.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

/**
 * Created by luoxiaocheng on 15/9/21.
 */
public class DisplayUtil {

    public static DisplayMetrics getDisplayMetrics(Context context) {

        return context.getResources().getDisplayMetrics();
    }

    public static int getDimenSize(Context context, int dimenId) {

        return context.getResources().getDimensionPixelOffset(dimenId);
    }

    public static int getScreenHeight(Context context) {

        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {

        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * dp转成px
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue, Context context) {
        return (int) (dipValue * getScale(context) + 0.5f);
    }

    private static float getScale(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * 获取图片的高度
     *
     * @param context
     * @param drawableId
     * @return
     */
    public static int getDrawableHeight(Context context, int drawableId) {

        int bottomHeight = 0;
        Drawable drawable = context.getResources().getDrawable(drawableId);
        bottomHeight = drawable.getIntrinsicHeight();
        return bottomHeight;
    }

    /**
     * 获取图片的宽度
     *
     * @param context
     * @param drawableId
     * @return
     */
    public static int getDrawableWidth(Context context, int drawableId) {

        int bottomWidth = 0;
        Drawable drawable = context.getResources().getDrawable(drawableId);
        bottomWidth = drawable.getIntrinsicWidth();
        return bottomWidth;
    }

    /**
     * 无标题了时高度
     *
     * @param context
     * @return
     */
    public static int getNoTitleBarHeight(Context context) {

        return getScreenHeight(context) - getNotifybarHeight(context);
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getNotifybarHeight(Context context) {

        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    private static int getMenuKeyHeight(Context context) {

        boolean b = ViewConfiguration.get(context).hasPermanentMenuKey();
        b = true;
        if (b) {

            Class<?> c = null;
            Object obj = null;
            Field field = null;
            int x = 0, statusBarHeight = 0;
            try {
                c = Class.forName("com.android.internal.R$dimen");
                obj = c.newInstance();
                field = c.getField("navigation_bar_height");
                x = Integer.parseInt(field.get(obj).toString());
                statusBarHeight = context.getResources().getDimensionPixelSize(x);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return statusBarHeight;
        } else
            return 0;
    }
}
