package com.sudao.module_login.presenters;

import android.content.Context;
import android.text.TextUtils;

import com.sudao.module_login.entitys.Consts;
import com.sudao.module_login.util.SharedPreferencesUtil;

/**
 * Created by pcdalao on 2017/9/1.
 */

public class LoginManager {
    private Context context;
    public LoginManager(Context context){
        this.context=context;
    }
    /**
     * 判断是否登录
     */
    public boolean isLogin() {
        String token = SharedPreferencesUtil.getInstance(context).readTempData(Consts.TOKEN);
        if (TextUtils.isEmpty(token)) {
            return false;
        }
        return true;
    }
}
