package com.sudao.module_login.presenters;

import android.content.Context;
import android.util.Log;

import com.sudao.module_login.api.LoginApi;
import com.sudao.module_login.entitys.Consts;
import com.sudao.module_login.entitys.ResCode;
import com.sudao.module_login.entitys.User;
import com.sudao.module_login.interfaces.AbstractLoginStartListener;
import com.sudao.module_login.presenters.network.RetrofitUtil;
import com.sudao.module_login.util.SharedPreferencesUtil;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by pcdalao on 2017/9/1.
 */

public class RegisterOperation {
    private Context mContext;
    private AbstractLoginStartListener abstractLoginStartListener;
    public RegisterOperation(Context context,AbstractLoginStartListener abstractLoginStartListener){
        this.mContext=context;
        this.abstractLoginStartListener=abstractLoginStartListener;
    }

    /**
     * 注册
     * @param phonenumber 手机号码
     * @param password   密码
     * @param authcode   验证码
     */
    public void OnRegister( final  String phonenumber,String password,String authcode){
        User muser=new User();
        muser.setCellphone(phonenumber);
        muser.setPassword(password);
        muser.setPhoneCode(authcode);

        RetrofitUtil.create(mContext, LoginApi.class).register(muser).subscribe(new Observer<ResCode<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ResCode<String> stringResCode) {
                if(stringResCode.getCode()==200){
                    HashMap<String, String> maps = new HashMap<>();
                    maps.put(Consts.TOKEN, stringResCode.getMessage());
                    maps.put(Consts.MOBILE, phonenumber);
                    SharedPreferencesUtil.getInstance(mContext).saveTempData(maps);
                    Log.d("TAG","注册成功");
                    abstractLoginStartListener.onSuccess(stringResCode.getMessage());
                }else {
                    Log.d("TAG","注册成功"+stringResCode.getMessage());
                    abstractLoginStartListener.onError(stringResCode.getCode(),stringResCode.getMessage());
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
     * 获取手机验证码
     * @param phonenumber
     */
    public void getAuthCode(String phonenumber){
        User user=new User();
        user.setCellphone(phonenumber);
        RetrofitUtil.create(mContext,LoginApi.class).getPhoneCode(user).subscribe(new Observer<ResCode<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ResCode<String> stringResCode) {
                if(stringResCode.getCode()==200) {
                    abstractLoginStartListener.onSuccess(stringResCode.getMessage());
                }else{
                    abstractLoginStartListener.onError(stringResCode.getCode(),stringResCode.getMessage());
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


}
