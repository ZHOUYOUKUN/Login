package com.sudao.module_share.entity;

/**
 * Created by pcdalao on 2017/9/7.
 */

/**
 * 图片枚举
 * 1，网络url类型图片
 * 2，file类型图
 * 3，项目R文件图片
 * 4，Bitmap类型图片
 * 5，byte字节图片
 */
public enum TYPE{
    IMAGEURL(1),
    FILES(2),
    R_DRAWABLE(3),
    BITMAPS(4),
    BYTES(5);

    private int nCode ;

    private TYPE( int _nCode) {
        this . nCode = _nCode;
    }

    public int tovaluse() {
        return this. nCode ;
    }
}

