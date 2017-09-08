package com.sh.sculuo.libluo.http.demomodel;


import com.sh.sculuo.libluo.http.Request;

/**
 * Created by luoxiaocheng on 2017/7/31.
 */

public class LoginReq extends Request {
    private String account;
    private String pwd;

    public LoginReq() {
    }

    public LoginReq(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
