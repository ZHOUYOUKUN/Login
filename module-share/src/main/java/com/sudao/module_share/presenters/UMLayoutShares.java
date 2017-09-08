package com.sudao.module_share.presenters;

import android.app.Activity;

import com.sudao.module_share.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.umeng.socialize.shareboard.ShareBoardConfig;


/**
 * Created by pcdalao on 2017/9/6.
 */

public class UMLayoutShares {
    private Activity activity;
    private  UMShareListener uMShareListener;
    public UMLayoutShares(Activity activity, UMShareListener uMShareListener){
        this.activity=activity;
    }

    /**
     * 平台面板，底部显示
     * @param shareBoardlistener
     */
    public void layoutBottonClick(ShareBoardlistener shareBoardlistener){
        UMImage pic = new UMImage(activity,R.drawable.ic_qq);
        pic.setThumb(new UMImage(activity, R.drawable.ic_qq));
        shareaction(shareBoardlistener).open();
    }

    /**
     * 平台面板，居中显示
     * @param shareBoardlistener
     */
    public void layoutCenterClick(ShareBoardlistener shareBoardlistener){

        ShareBoardConfig config = new ShareBoardConfig();
        config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER);
        config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_CIRCULAR); // 圆角背景
        config.setTitleVisibility(false); // 隐藏title
                config.setCancelButtonVisibility(false); // 隐藏取消按钮
        shareaction(shareBoardlistener).open(config);
    }

    /**
     * 面板添加需要分享的平台，构建ShareAction
     * @param shareBoardlistener
     * @return
     */
    public ShareAction shareaction(ShareBoardlistener shareBoardlistener){
        ShareAction mShareAction = new ShareAction(activity).setDisplayList(
                SHARE_MEDIA.WEIXIN,
                SHARE_MEDIA.QQ,
                SHARE_MEDIA.SINA,
                SHARE_MEDIA.QZONE,
                SHARE_MEDIA.WEIXIN_CIRCLE,
                SHARE_MEDIA.WEIXIN_FAVORITE
        )
                .setShareboardclickCallback(shareBoardlistener);
        return mShareAction;
    }

}
