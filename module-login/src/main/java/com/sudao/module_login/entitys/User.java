package com.sudao.module_login.entitys;

/**
 * Created by pcdalao on 2017/8/29.
 */

public class User {
    /**
     * cellphone 手机号码
     */
    private String cellphone;
    /**
     * username 用户名
     */
    private String username;
    /**
     * password 密码
     */
    private String password;
    /**
     * newPassword 新密码
     */
    private String newPassword;
    /**
     * phoneCode 验证码
     */
    private String phoneCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
