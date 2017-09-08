package com.sh.sculuo.libluo.http.interceptor;


import com.sh.sculuo.libluo.util.SPUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 */
public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                if (header.contains("_MCH_AT=\"\"") || header.contains("_MCH_AT=;")) {
                    return originalResponse;
                }
                cookies.add(header);
            }
            SPUtil.saveSet("cookie", cookies);
        }

        return originalResponse;
    }
}
