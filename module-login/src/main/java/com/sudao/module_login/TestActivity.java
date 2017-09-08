package com.sudao.module_login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sudao.module_login.R;
import com.sudao.module_login.api.LoginApi;
import com.sudao.module_login.entitys.User;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * Created by pcdalao on 2017/8/30.
 */

public class TestActivity  extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
    }
    public void test(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory( GsonConverterFactory.create()).build();
       LoginApi loggin=  retrofit.create(LoginApi.class);
        loggin.getPhoneCode(new User()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    public void okhttptest() throws IOException {
        OkHttpClient httpClient=new OkHttpClient();
        Request request=new Request.Builder().url("").build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }

}
