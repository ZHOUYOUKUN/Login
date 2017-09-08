package com.sh.sculuo.libluo.http.interceptor;


import com.sh.sculuo.libluo.util.SPUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by luoxiaocheng on 2017/4/24.
 */

public class HeaderInterceptor implements Interceptor {
    private Headers headers;

    public HeaderInterceptor(Headers headers) {
        this.headers = headers;
    }

    public HeaderInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        Set<String> preferences = (HashSet) SPUtil.getSet("cookie");

        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
        }
        if (headers != null)
            builder.headers(headers);
        return chain.proceed(builder.build());
    }
}
