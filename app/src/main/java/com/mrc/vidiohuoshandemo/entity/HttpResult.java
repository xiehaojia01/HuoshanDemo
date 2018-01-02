package com.mrc.vidiohuoshandemo.entity;

/**
 * 请求数据泛型封装
 * Created by  on 2017/12/26.
 */

public class HttpResult<D> {

    public D data;

    public String message;

    public int status_code;

    public static String SUCCESS = "success";
    public static String SIGN_OUT = "101";//token验证失败
    public static String SHOW_TOAST = "102";//显示Toast

    public boolean hasmore;
    public boolean error;

    public boolean isSuccess() {
        return !error;
    }

    public boolean isTokenInvalid() {
        return SIGN_OUT.equals(status_code);
    }

    public boolean isShowToast() {
        return SHOW_TOAST.equals(status_code);
    }

    public boolean hasMore() {
        return hasmore;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status_code=" + status_code +
                '}';
    }
}
