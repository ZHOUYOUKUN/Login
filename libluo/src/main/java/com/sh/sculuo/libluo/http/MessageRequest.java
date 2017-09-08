package com.sh.sculuo.libluo.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoxiaocheng on 2017/7/31.
 */

public class MessageRequest {
    public String session;
    public Map<String, String> headers=new HashMap<>();
    public Request request;
    public String method;
    public String apiMethod;
}
