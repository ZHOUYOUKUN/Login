package com.sudao.module_share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sudao.module_share.activity.ShareActivity;
import com.sudao.module_share.dialog.ShareDialog;
import com.sudao.module_share.entity.ImageShareType;
import com.sudao.module_share.entity.WebURL;
import com.sudao.module_share.presenters.CustomShare;
import com.sudao.module_share.presenters.UMLayoutShares;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

/**
 * Created by pcdalao on 2017/9/6.
 */

public class TestActivity extends ShareActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

    }

    /**
     * 平台面板居中点击事件
     * @param v
     */
    public void layoutCenterClick(View v) {
        new UMLayoutShares(TestActivity.this, shareListener).layoutCenterClick(shareBoardlistener);
    }
    /**
     * 平台面板底部点击事件
     * @param v
     */
    public void layoutBottonClick(View v) {
        new UMLayoutShares(TestActivity.this, shareListener).layoutBottonClick(shareBoardlistener);
    }
    /**
     * 纯文本分享
     * @param v
     */
    public void TextShareClick(View v) {
        new CustomShare().textShare(TestActivity.this, "我的分享", shareListener, SHARE_MEDIA.QZONE);
    }
    /**
     * 图片分享
     * @param v
     */
    public void ImageShareClick(View v) {
        ImageShareType imageShareType = new ImageShareType();

        //UMImage image = new UMImage(TestActivity.this, "imageurl");//网络图片
        //UMImage image = new UMImage(TestActivity.this, file);//本地文件
        UMImage image = new UMImage(TestActivity.this, R.drawable.ic_qq);//资源文件
        //UMImage image = new UMImage(TestActivity.this, bitmap);//bitmap文件
        //UMImage image = new UMImage(TestActivity.this, byte[]);//字节流

        imageShareType.setUmImage(image);

        new CustomShare().imageShare(TestActivity.this, shareListener, imageShareType, SHARE_MEDIA.QZONE);
    }

    /**
     * url分享
     * @param v
     */
    public void URLShareClick(View v) {
        WebURL webURL = new WebURL();
        webURL.setUrl("http://www.baidu.com");
        webURL.setUrltitle("网址分享");
        webURL.setDescription("分享描述");
        //UMImage image = new UMImage(TestActivity.this, "imageurl");//网络图片
        //UMImage image = new UMImage(TestActivity.this, file);//本地文件
        UMImage image = new UMImage(TestActivity.this, R.drawable.ic_qq);//资源文件
        //UMImage image = new UMImage(TestActivity.this, bitmap);//bitmap文件
        //UMImage image = new UMImage(TestActivity.this, byte[]);//字节流
        //  webURL.setUmImage(image);
        new CustomShare().WebUrlShare(TestActivity.this, shareListener, webURL, SHARE_MEDIA.QZONE);
    }
    /**
     * 自定义面板底部点击事件
     * @param v
     */
    public void CustomShareClick(View v) {
        ShareDialog shareDialog = new ShareDialog(TestActivity.this);
        shareDialog.setBottomDialogParam(shareDialog);
        shareDialog.show();
    }
    /**
     * 自定义面板居中点击事件
     * @param v
     */
    public void CenterCustomShareClick(View v) {

        ShareDialog shareDialog = new ShareDialog(TestActivity.this);
        shareDialog.show();
    }

    /**
     * 带面板点击事件监听
     * 打开面板后，具体点击后的操作，此处为真正分享代码的处理,WebUrlShare虚根据具体情况选择是url，图片或文本
     * CustomShare中定义了当前支持的分享类型，如文本，图片，视频，引用，url，具体请看CustomShare
     *
     */
    public ShareBoardlistener shareBoardlistener = new  ShareBoardlistener() {

        @Override
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
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
        }
    };
}