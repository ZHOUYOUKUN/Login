package com.sudao.module_share.listener;

import com.sudao.module_share.R;
import com.sudao.module_share.TestActivity;
import com.sudao.module_share.entity.WebURL;
import com.sudao.module_share.presenters.CustomShare;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

/**
 * Created by pcdalao on 2017/9/8.
 */

public class ShareBoardlisteners implements ShareBoardlistener {
    /**
     *
     * @param snsPlatform
     * @param share_media   该枚举根据具体分享的平台
     *                      然后将内容内容继承该类，在该处实现客制化
     */
    @Override
    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
       /* 例如：
        WebURL webURL = new WebURL();
        webURL.setUrl("http://www.baidu.com");
        webURL.setUrltitle("网址分享");
        webURL.setDescription("分享描述");
        //UMImage image = new UMImage(TestActivity.this, "imageurl");//网络图片
        //UMImage image = new UMImage(TestActivity.this, file);//本地文件
        //UMImage image = new UMImage(TestActivity.this, R.drawable.ic_qq);//资源文件
        //UMImage image = new UMImage(TestActivity.this, bitmap);//bitmap文件
        //UMImage image = new UMImage(TestActivity.this, byte[]);//字节流
        webURL.setUmThumbImage(new UMImage(TestActivity.this, R.drawable.ic_qq));
        new CustomShare().WebUrlShare(TestActivity.this, shareListener, webURL, share_media);
        */
    }
}
