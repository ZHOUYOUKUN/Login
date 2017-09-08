package com.sudao.module_share.entity;

import android.app.Activity;
import android.graphics.Bitmap;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.File;

/**
 * Created by pcdalao on 2017/9/7.
 */

public class ImageShareType {
    /*
    UMImage image = new UMImage(ShareActivity.this, "imageurl");//网络图片
    UMImage image = new UMImage(ShareActivity.this, file);//本地文件
    UMImage image = new UMImage(ShareActivity.this, R.drawable.xxx);//资源文件
    UMImage image = new UMImage(ShareActivity.this, bitmap);//bitmap文件
    UMImage image = new UMImage(ShareActivity.this, byte[]);//字节流
    */

    //缩略图
    public UMImage umthumbImage;
    //分享图
    public UMImage umImage;

    public UMImage getUmthumbImage() {
        return umthumbImage;
    }

    public UMImage getUmImage() {
        return umImage;
    }

    public void setUmthumbImage(UMImage umthumbImage) {
        this.umthumbImage = umthumbImage;
    }

    public void setUmImage(UMImage umImage) {
        this.umImage = umImage;
    }
}
