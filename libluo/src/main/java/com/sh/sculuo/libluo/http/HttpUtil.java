package com.sh.sculuo.libluo.http;

/**
 * Created by luoxiaocheng on 2017/5/23.
 */

public class HttpUtil {
    private static HttpApi api;

    public static HttpApi getApi() {
        if (api == null) {
            api = ServiceGenerator.createService(HttpApi.class);
        }
        return api;
    }
}
