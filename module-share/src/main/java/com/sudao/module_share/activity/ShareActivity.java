package com.sudao.module_share.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.sh.sculuo.libluo.base.BaseActivity;
import com.sudao.module_share.R;
import com.sudao.module_share.TestActivity;
import com.sudao.module_share.dialog.ShareDialog;
import com.sudao.module_share.entity.WebURL;
import com.sudao.module_share.presenters.CustomShare;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

/**
 * Created by pcdalao on 2017/9/6.
 */

public abstract  class ShareActivity extends BaseActivity{
    static  String url="http://www.baidu.com";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
    }

    /**
     * 权限请求结果
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if(requestCode==123){
            Toast.makeText(ShareActivity.this,"权限没有被同意",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }



    /**
     * 自定义面板底部显示
     */
    public void setCustomLayoutBottomShare(){
        ShareDialog shareDialog = new ShareDialog(ShareActivity.this);
        shareDialog.setBottomDialogParam(shareDialog);
        shareDialog.show();
    }

    public void setCustomLayoutCenterShare(){
        ShareDialog shareDialog = new ShareDialog(ShareActivity.this);
        shareDialog.show();
    }
    /**
     * 释放资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }
}
