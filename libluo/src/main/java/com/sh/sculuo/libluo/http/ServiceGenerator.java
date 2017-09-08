package com.sh.sculuo.libluo.http;


import com.sh.sculuo.libluo.Testing;
import com.sh.sculuo.libluo.http.interceptor.AddCookiesInterceptor;
import com.sh.sculuo.libluo.http.interceptor.CacheControlInterceptor;
import com.sh.sculuo.libluo.http.interceptor.HttpLoggingInterceptor;
import com.sh.sculuo.libluo.http.interceptor.ReceivedCookiesInterceptor;
import com.sh.sculuo.libluo.util.FileUtil;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samuel on 5/23/16 19:03
 * Email:xuzhou40@gmail.com
 * desc: service生成类
 */
public class ServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Config.baseUrl + "/")
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        if (Config.isCookiesAble)
            httpClient.addInterceptor(new AddCookiesInterceptor());

        if (Config.isReceivedCookiesAble)
            httpClient.addInterceptor(new ReceivedCookiesInterceptor());

        HttpLoggingInterceptor.Level body = HttpLoggingInterceptor.Level.BODY;
        if (!Testing.isTesting) {
            body = HttpLoggingInterceptor.Level.NONE;
        }
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(body));

        if (Config.isCacheAble) {
            httpClient.addInterceptor(new CacheControlInterceptor());
            File cacheFile = FileUtil.getCacheFile("net_cache");
            Cache cache = new Cache(cacheFile, 10 * 100 * 100);
            httpClient.cache(cache);
        }
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public static OkHttpClient.Builder getHttpClient() {
        return httpClient;
    }

    public static Retrofit.Builder getBuilder() {
        return builder;
    }
}
