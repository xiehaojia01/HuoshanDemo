package com.mrc.vidiohuoshandemo.entity;

/**
 * Created by  on 2017/12/26.
 */

public class HttpResultExtra<D, E> {
    public D data;

    public String message;

    public E extra;

    public int status_code;

    @Override
    public String toString() {
        return "HttpResult{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", extra=" + extra +
                ", status_code=" + status_code +
                '}';
    }
}
