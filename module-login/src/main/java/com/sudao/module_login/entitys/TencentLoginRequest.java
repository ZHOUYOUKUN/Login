package com.sudao.module_login.entitys;

/**
 * Created by pan jh on 2017/6/19.
 */

public class TencentLoginRequest {

    /**
     * openid : oDI30wQxGqxIpTKRqfG_0-N5Nauw
     * accessToken : OezXcEiiBSKSxW0eoylIeLQXuZGnVpKMZJpEI0Of620d_S_clsucD-mtGU6aPaDoGLn0ouGyQuDLHO10-1o7oIHq_lgdM_SfmFnUeyPtt2DTvqo9yOPKI3FkRmcyE-ai_uRLgooVeGRo9CqOQeD7ag
     */
    private String openid;
    private String accessToken;

    public TencentLoginRequest(String openid, String accessToken) {
        this.openid = openid;
        this.accessToken = accessToken;
    }

    public TencentLoginRequest() {}

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenid() {
        return openid;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
