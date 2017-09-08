package com.sh.sculuo.libluo.http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luoxiaocheng on 2017/5/23.
 */

public abstract class HttpCallback<T> implements Callback<BaseRes<T>> {

    @Override
    public void onResponse(Call<BaseRes<T>> call, Response<BaseRes<T>> response) {
        if (response != null) {
            if (response.code() == 200) {
                BaseRes<T> body = response.body();
                if (body != null) {
                    int code = body.getCode();
                    if (code == BaseRes.state_success) {
                        onRes(call, body.getResponse());
                        complate();
                    } else {
                        complate();
                        resError(call, code, body.getMsg());
                    }
                } else {
                    complate();
                    resError(call, -1, "服务器出错了,请联系客服!");
                }
            } else {
                onError(call, response.code());
            }
        } else {
            onError(call, -1);
        }
    }

    @Override
    public void onFailure(Call<BaseRes<T>> call, Throwable throwable) {

    }

    public void onError(Call<BaseRes<T>> call, int netcode) {
        complate();
    }

    public void complate() {

    }

    public abstract void onRes(Call<BaseRes<T>> call, T t);

    public void resError(Call<BaseRes<T>> call, int code, String errorMsg) {
    }
}
