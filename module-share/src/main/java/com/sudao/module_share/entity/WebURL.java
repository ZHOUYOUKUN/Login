package com.sudao.module_share.entity;

import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by pcdalao on 2017/9/7.
 */

public class WebURL {
    //分享的url地址
    public String url;
    //分享的web标题
    public String urltitle;
    //分享的描述
    public String description;
    //分享的缩略图
    public UMImage umThumbImage;
    //跳转链接
    public String targetUrl;
    //小程序分享的路径
    public String path;
    //小程序分享的用户名
    public String userName;

    public String getUrl() {
        return url;
    }

    public String getUrltitle() {
        return urltitle;
    }

    public String getDescription() {
        return description;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrltitle(String urltitle) {
        this.urltitle = urltitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public UMImage getUmThumbImage() {
        return umThumbImage;
    }

    public void setUmThumbImage(UMImage umThumbImage) {
        this.umThumbImage = umThumbImage;
    }

    public String getPath() {
        return path;
    }

    public String getUserName() {
        return userName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
