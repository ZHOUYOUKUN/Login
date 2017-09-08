package com.sudao.module_login.api;

import com.sudao.module_login.entitys.Consts;
import com.sudao.module_login.entitys.ResCode;
import com.sudao.module_login.entitys.TencentLoginRequest;
import com.sudao.module_login.entitys.User;
import com.sudao.module_login.entitys.UserAuthenticationData;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by pcdalao on 2017/8/30.
 */

public interface LoginApi {

    @POST(Consts.WEB_PATH + "app/auth/login")
    Observable<ResCode<String>> login(@Body User loginRequest);
    /**
     * qq登录
     */
    @POST(Consts.WEB_PATH + "app/auth/qq")
    Observable<ResCode<String>> thirdLoginQQ(@Body TencentLoginRequest request);

    /**
     * 微信登录
     */
    @POST(Consts.WEB_PATH + "app/auth/wx")
    Observable<ResCode<String>> thirdLoginWechat(@Body TencentLoginRequest request);
    /**
     * 用户注册
     * cellphone 手机号码
     * password 密码
     * phoneCode 验证码
     */
    @POST(Consts.WEB_PATH + "app/register")
    Observable<ResCode<String>> register(@Body User loginRequest);
    /**
     * 获取短信验证码
     * cellphone 手机号码
     */
    @POST(Consts.WEB_PATH + "phoneCode/single")
    Observable<ResCode<String>> getPhoneCode(@Body User loginRequest);


}
