package com.sh.sculuo.libluo.http.demomodel;


import com.sh.sculuo.libluo.http.Response;

/**
 * Created by luoxiaocheng on 2017/7/31.
 */

public class LoginRes extends Response {
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
