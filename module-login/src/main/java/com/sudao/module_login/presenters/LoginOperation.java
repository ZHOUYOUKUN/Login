package com.sudao.module_login.presenters;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.sudao.module_login.api.LoginApi;
import com.sudao.module_login.entitys.Consts;
import com.sudao.module_login.entitys.ResCode;
import com.sudao.module_login.entitys.TencentLoginRequest;
import com.sudao.module_login.entitys.User;
import com.sudao.module_login.interfaces.AbstractLoginStartListener;
import com.sudao.module_login.presenters.network.RetrofitUtil;
import com.sudao.module_login.util.SharedPreferencesUtil;

import java.util.HashMap;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by pcdalao on 2017/8/29.
 */

public class LoginOperation {
    private  Context context;
    private AbstractLoginStartListener loginStartListener;
    public static final int QQ_UNBIND = 6130;
    public static final int WECHAT_UNBIND = 6131;

    public LoginOperation(Context context,AbstractLoginStartListener loginStartListener){
        this.context=context;
        this.loginStartListener=loginStartListener;
    }

    /**
     * 用户名密码登录
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        RetrofitUtil.create(context, LoginApi.class).login(user).subscribe(new Observer<ResCode<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ResCode<String> stringResCode) {
                Log.d("TAG","onNext");
                if(stringResCode.getCode()==200){
                    Log.d("TAG","succ");
                    //接口监听，返回ui数据
                    loginStartListener.onSuccess(stringResCode.getData());
                }else{
                    Log.d("TAG","error"+stringResCode.getCode());
                    loginStartListener.onError(stringResCode.getCode(),stringResCode.getMessage());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * qq登录
     @param
     */
    public void qqLogin() {
        UmengLoginHelper loginHelper=new UmengLoginHelper((Activity) context,new UmengLoginHelper.UmengLoginListener() {
            @Override
            public void onLoginSuccess(final TencentLoginRequest request) {

                RetrofitUtil.create(context, LoginApi.class).thirdLoginQQ(request).
                        subscribe(new Observer<ResCode<String>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull ResCode<String> stringResCode) {
                                Log.d("TAG","onNext");
                                if(stringResCode.getCode()==200){
                                    Log.d("TAG","succ");
                                    HashMap<String, String> maps = new HashMap<>();
                                    maps.put(Consts.TOKEN, stringResCode.getData());
                                    SharedPreferencesUtil.getInstance(context).saveTempData(maps);
                                    //getProfile();
                                    loginStartListener.onSuccess(stringResCode.getData());
                                }else{
                                    Log.d("TAG","error"+stringResCode.getCode());
                                    loginStartListener.onError(stringResCode.getCode(),stringResCode.getMessage());
                                    if (stringResCode.getCode() == QQ_UNBIND) {
                                        Log.d("TAG","需绑定手机");
                                    }
                                }
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
        loginHelper.qqLogin();
    }

    /**
     * 微信登录
     * @param activity
     */
    public void wechatLogin(Activity activity) {
        UmengLoginHelper loginHelper=new UmengLoginHelper(activity, new UmengLoginHelper.UmengLoginListener() {
            @Override
            public void onLoginSuccess(final TencentLoginRequest request) {
                RetrofitUtil.create(context,LoginApi.class).thirdLoginWechat(request).
                        subscribe(new Observer<ResCode<String>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull ResCode<String> stringResCode) {
                                Log.d("TAG","onNext");
                                if(stringResCode.getCode()==200){
                                    Log.d("TAG","succ");
                                    HashMap<String, String> maps = new HashMap<>();
                                    maps.put(Consts.TOKEN, stringResCode.getData());
                                    SharedPreferencesUtil.getInstance(context).saveTempData(maps);
                                    //getProfile();
                                    loginStartListener.onSuccess(stringResCode.getData());
                                }else{
                                    Log.d("TAG","error"+stringResCode.getCode());
                                    loginStartListener.onError(stringResCode.getCode(),stringResCode.getMessage());
                                    if (stringResCode.getCode() == WECHAT_UNBIND) {
                                        Log.d("TAG","需绑定手机");
                                    }
                                }
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
        loginHelper.wechatLogin();
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
