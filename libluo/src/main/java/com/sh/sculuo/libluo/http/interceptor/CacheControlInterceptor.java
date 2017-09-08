package com.sh.sculuo.libluo.http.interceptor;


import com.sh.sculuo.libluo.util.AppHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 */
public class CacheControlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (AppHelper.isNetworkConnected()) {
            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
        } else {
            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
        }
        return chain.proceed(request);
    }
}
