package com.sudao.module_share.presenters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;

import com.sudao.module_share.entity.ImageShareType;
import com.sudao.module_share.entity.WebURL;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;

/**
 * Created by pcdalao on 2017/9/7.
 */

public class CustomShare {
    private String TAG="com.sudao.ShareUtil";
    /**
     * 纯文本分享，可能有的平台不支持纯文本分享，如qq，这个需要三方平台支持
     *
     * @param activity   分享activity，建议传入activity，方便生命周期管理
     * @param text       分享的文字内容
     * @param umShareListener    分享后的的状态监听，需要实现UMShareListener
     * @param share_media        share_media指分享的平台，取值如下：
     *                  GOOGLEPLUS,
    GENERIC,
    SMS,
    EMAIL,
    SINA,
    QZONE,
    QQ,
    RENREN,
    WEIXIN,
    WEIXIN_CIRCLE,
    WEIXIN_FAVORITE,
    TENCENT,
    DOUBAN,
    FACEBOOK,
    FACEBOOK_MESSAGER,
    TWITTER,
    LAIWANG,
    LAIWANG_DYNAMIC,
    YIXIN,
    YIXIN_CIRCLE,
    INSTAGRAM,
    PINTEREST,
    EVERNOTE,
    POCKET,
    LINKEDIN,
    FOURSQUARE,
    YNOTE,
    WHATSAPP,
    LINE,
    FLICKR,
    TUMBLR,
    ALIPAY,
    KAKAO,
    DROPBOX,
    VKONTAKTE,
    DINGTALK,
    MORE;
     */
    public void textShare(Activity activity, String text, UMShareListener umShareListener,SHARE_MEDIA share_media) {

//        if (UMShareAPI.get(activity).isInstall(activity, share_media)) {
        new ShareAction(activity)
                .withText(text)
                .setPlatform(share_media)
                .setCallback(umShareListener)
                .share();
//        }else {
//            Log.d(TAG,"应用没有安装");
//        }
    }
    public void build(){

    }

    /**
     * 图片分享
     *
     * @param activity  建议传入activity，方便生命周期管理
     * @param umShareListener  分享后的的状态监听，需要实现UMShareListener
     * @param imageShareType   构建具体的分享实体，
     */
    public void imageShare(Activity activity, UMShareListener umShareListener, ImageShareType imageShareType,SHARE_MEDIA share_media){

        UMImage image=imageShareType.getUmImage();
        //推荐使用网络图片和资源文件的方式，平台兼容性更高。 对于部分平台，分享的图片需要设置缩略图，缩略图的设置规则为：
        if(null!=imageShareType.getUmthumbImage()) {
            image.setThumb(imageShareType.getUmthumbImage());
        }
        // 用户设置的图片大小最好不要超过250k，缩略图不要超过18k，
        // 如果超过太多（最好不要分享1M以上的图片，压缩效率会很低），
        // 图片会被压缩。 用户可以设置压缩的方式：
        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        //image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
        //   压缩格式设置
        //image.compressFormat = Bitmap.CompressFormat.PNG;//用户分享透明背景的图片可以设置这种方式，但是qq好友，微信朋友圈，不支持透明背景图片，会变成黑色

        new ShareAction(activity)
                .withMedia(image)
                .setPlatform(share_media)
                .setCallback(umShareListener)
                .share();


    }

    /**
     * url类型分享
     *
     * @param activity  上下文
     * @param umShareListener   分享结束后的监听
     * @param webURL    分享内容实体类
     * @param share_media  分享平台
     */
    public void WebUrlShare(Activity activity,UMShareListener umShareListener,WebURL webURL,SHARE_MEDIA share_media){
        UMWeb web = new UMWeb(webURL.getUrl());
        web.setTitle(webURL.getUrltitle());//标题
        web.setThumb(webURL.getUmThumbImage());  //缩略图
        web.setDescription(webURL.getDescription());//描述
        new ShareAction(activity)
                .setPlatform(share_media)
                .withMedia(web)
                .setCallback(umShareListener)
                .share();
    }

    /**
     *视频分享类，、
     * 视频只能使用网络视频，给出相应的url
     *
     *  @param activity  上下文
     * @param umShareListener   分享结束后的监听
     * @param webURL    分享内容实体类
     * @param share_media  分享平台
     */
    public void VideoShare(Activity activity,UMShareListener umShareListener,WebURL webURL,SHARE_MEDIA share_media){
        UMVideo video = new UMVideo(webURL.getUrl());
        video.setTitle(webURL.getUrltitle());//视频的标题
        video.setThumb(webURL.getUmThumbImage());//视频的缩略图
        video.setDescription(webURL.getDescription());//视频的描述
        new ShareAction(activity)
                .withMedia(video)
                .setCallback(umShareListener)
                .share();
    }
    public void test(Activity activity, UMShareListener umShareListener, BaseMediaObject object,SHARE_MEDIA share_media){
        new ShareAction(activity)
                .setPlatform(share_media)
                .withMedia((UMImage) object)
                .setCallback(umShareListener)
                .share();
    }


    /**
     * 分享音乐
     * 只支持网络音乐的分享
     * 注意：播放链接是指在微信qq分享音乐，是可以在当前聊天界面播放的，要求这个musicurl（播放链接）必须要以.mp3等音乐格式结尾，跳转链接是指点击linkcard之后进行跳转的链接。
     * @param activity
     * @param umShareListener
     * @param webURL
     * @param share_media
     */
    public void MusicShare(Activity activity,UMShareListener umShareListener,WebURL webURL,SHARE_MEDIA share_media){
        UMusic music = new UMusic(webURL.getUrl());//音乐的播放链接
        music.setTitle(webURL.getUrltitle());//音乐的标题
        music.setThumb(webURL.getUmThumbImage());//音乐的缩略图
        music.setDescription(webURL.getDescription());//音乐的描述
        music.setmTargetUrl(webURL.getTargetUrl());//音乐的跳转链接
        new ShareAction(activity)
                .setPlatform(share_media)
                .withMedia(music)
                .setCallback(umShareListener)
                .share();
    }
    /**
     * 分享gif
     *
     * 注意：目前只有微信好友分享支持Emoji表情，其他平台暂不支持
     * @param activity
     * @param umShareListener
     * @param webURL
     * @param share_media
     */
    public void GIFShare(Activity activity,UMShareListener umShareListener,WebURL webURL,SHARE_MEDIA share_media){
        UMEmoji emoji = new UMEmoji(activity,webURL.getUrl());
        emoji.setThumb(webURL.getUmThumbImage());
        new ShareAction(activity)
                .withMedia(emoji)
                .setPlatform(share_media)
                .setCallback(umShareListener)
                .share();
    }
    /**
     * 微信小程序分享
     *
     * 注意：目前只有微信好友支持小程序分享，朋友圈，收藏及其他平台暂不支持
     * @param activity
     * @param umShareListener
     * @param webURL
     * @param share_media
     */
    public void WeiXinSoft(Activity activity,UMShareListener umShareListener,WebURL webURL,SHARE_MEDIA share_media){
        UMMin umMin = new UMMin(webURL.getUrl());
        umMin.setThumb(webURL.getUmThumbImage());
        umMin.setTitle(webURL.getUrltitle());
        umMin.setDescription(webURL.getDescription());
        umMin.setPath(webURL.getPath());
        umMin.setUserName(webURL.getUserName());

        new ShareAction(activity)
                .withMedia(umMin)
                .setPlatform(share_media)
                .setCallback(umShareListener)
                .share();
    }


}
