package com.sh.sculuo.libluo.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.ScrollView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by luoxiaocheng on 2017/7/22.
 */

public class BitmapUtil {
    /**
     * bitmap 转file
     *
     * @param bmp
     * @param path
     * @return
     */
    public static File bitmapToPath(Bitmap bmp, String path) {
        return bitmapToPath(bmp, new File(path));
    }

    /**
     * * bitmap 转file
     *
     * @param bmp
     * @param file
     * @return
     */
    public static File bitmapToPath(Bitmap bmp, File file) {
        if (bmp == null) {
            return null;
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
            bmp.recycle();
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
//        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(),
//                    file.getAbsolutePath(), file.getPath(), null);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
        return file;
    }

    /**
     * 控件视图转bitmap
     *
     * @param v
     * @return
     */
    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }

    /**
     * 控件视图转bitmap
     *
     * @param v
     * @param width
     * @param height
     * @return
     */
    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }

    /**
     * 根据文本宽度+文本+字大小 获取所占空间高度
     *
     * @param width
     * @param text
     * @param textSize
     * @return
     */
    public static int calcTextViewHeightByContent(int width, String text, float textSize) {

        TextPaint textPaint = new TextPaint();

        // textPaint.setARGB(0x31, 0x31, 0x31, 0);
        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);// 消除锯齿
        textPaint.setTextSize(textSize);

        StaticLayout layout = new StaticLayout(text, textPaint, width,
                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);

        int height = layout.getHeight();
        return height;

    }

    /**
     * 截取scrollview的屏幕
     **/
    public static Bitmap getScrollViewBitmap(ScrollView scrollView, String picpath) {
        int h = 0;
        Bitmap bitmap;
        // 获取listView实际高度
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            h += scrollView.getChildAt(i).getHeight();
        }
        LogUtil.d("bitmaputil", "实际高度:" + h);
        LogUtil.d("bitmaputil", " 高度:" + scrollView.getHeight());
        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(scrollView.getWidth(), h,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        scrollView.draw(canvas);
        // 测试输出
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(picpath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (null != out) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            }
        } catch (IOException e) {
        }
        return bitmap;
    }

    /**
     * 截取scrollview的屏幕
     **/
    public static Bitmap getScrollViewBitmap(RecyclerView scrollView, String picpath) {
        int h = 0;
        Bitmap bitmap;
        // 获取listView实际高度
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            h += scrollView.getChildAt(i).getHeight();
        }
        LogUtil.d("bitmaputil", "实际高度:" + h);
        LogUtil.d("bitmaputil", " 高度:" + scrollView.getHeight());
        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(scrollView.getWidth(), h,
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        scrollView.draw(canvas);
        // 测试输出
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(picpath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (null != out) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            }
        } catch (IOException e) {
        }
        return bitmap;
    }
}
