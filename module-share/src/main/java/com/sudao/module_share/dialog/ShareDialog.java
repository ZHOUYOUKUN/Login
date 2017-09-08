package com.sudao.module_share.dialog;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.sudao.module_share.R;
import com.sudao.module_share.activity.ShareActivity;
import com.sudao.module_share.entity.ImageShareType;
import com.sudao.module_share.entity.WebURL;
import com.sudao.module_share.presenters.CustomShare;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by pcdalao on 2017/9/7.
 */

public class ShareDialog extends Dialog implements View.OnClickListener{
    private Activity context;
    public ShareDialog(@NonNull Activity context) {
        super(context, R.style.Dialog);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View layout = inflater.inflate(R.layout.dialog_share,null);
        addContentView(layout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        layout.findViewById(R.id.iv_wechat).setOnClickListener(this);
        layout.findViewById(R.id.iv_wechat_circle).setOnClickListener(this);
        layout.findViewById(R.id.iv_qq_zone).setOnClickListener(this);
        layout.findViewById(R.id.iv_qq).setOnClickListener(this);
        layout.findViewById(R.id.tv_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.iv_wechat){
            new CustomShare().textShare(context,"微信分享",shareListener,SHARE_MEDIA.QZONE);

        }else if(v.getId()==R.id.iv_wechat_circle){
            ImageShareType imageShareType=new ImageShareType();
            /*
             UMImage image = new UMImage(ShareActivity.this, "imageurl");//网络图片
             UMImage image = new UMImage(ShareActivity.this, file);//本地文件
             UMImage image = new UMImage(ShareActivity.this, R.drawable.xxx);//资源文件
             UMImage image = new UMImage(ShareActivity.this, bitmap);//bitmap文件
             UMImage image = new UMImage(ShareActivity.this, byte[]);//字节流
             */

            imageShareType.setUmImage(new UMImage(context,R.drawable.kuaicto));
            new CustomShare().imageShare(context,shareListener,imageShareType,SHARE_MEDIA.QZONE);

        }else if(v.getId()==R.id.iv_qq_zone){
            WebURL url=new WebURL();
            url.setUrl("http://www.baidu.com");
            url.setUrltitle("百度");
            url.setDescription("最大的中文收索引擎");
            url.setUmThumbImage(new UMImage(context,R.drawable.koala));
            new CustomShare().WebUrlShare(context,shareListener,url,SHARE_MEDIA.QQ);

        }else if(v.getId()==R.id.iv_qq) {
            WebURL url=new WebURL();
            url.setUrl("http://www.baidu.com");
            url.setUrltitle("music");

            url.setTargetUrl("http://link.hhtjim.com/baidu/2064974.mp3");
            url.setUmThumbImage(new UMImage(context,R.drawable.koala));

            new CustomShare().MusicShare(context,shareListener,url,SHARE_MEDIA.QQ);

        }

        dismiss();
    }
    /**
     * 设置底部Dialog宽度和高度
     */
    public static void setBottomDialogParam(Dialog dialog) {
        dialog.getWindow().getDecorView().setPadding(0,0,0,0);   //去除Dialog边框
        dialog.getWindow().setWindowAnimations(R.style.ActionSheetDialogAnimation);   //设置进出动画

        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(lp);
    }

    /**
     * 分享监听回调
     */
    public UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}