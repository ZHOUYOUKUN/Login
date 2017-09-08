package com.sh.sculuo.libluo.callback;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by luoxiaocheng on 2017/5/20.
 */

public abstract class PlatformCallback implements UMAuthListener {
    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        String uid = map.get("uid");
        String name = map.get("name");
        String gender = map.get("gender");
        String iconurl = map.get("iconurl");
    }
}
