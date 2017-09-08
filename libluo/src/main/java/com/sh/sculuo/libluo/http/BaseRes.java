package com.sh.sculuo.libluo.http;

public class BaseRes<T> {
    public final static int state_success = 0;
    private int code = -1;
    private String msg;
    private T Response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResponse() {
        return Response;
    }

    public void setResponse(T response) {
        Response = response;
    }
}
