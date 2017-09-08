package com.sudao.module_login.interfaces;

/**
 * Created by pcdalao on 2017/8/30.
 * 登录状态
 */

public interface LoginStartListener {
    public void onSuccess(String str);
    public void onError(int code,String str);
}
