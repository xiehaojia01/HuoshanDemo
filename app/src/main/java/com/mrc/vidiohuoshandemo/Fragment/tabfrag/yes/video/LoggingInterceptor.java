package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video;

import android.os.Build;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Lenovo
 * @date 2017/12/28
 * /**
 * 网络拦截器
 */

public class LoggingInterceptor implements Interceptor {
    private static final String UA = "User-Agent";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader(UA, makeUA())
                .build();
        return chain.proceed(request);
    }
    private String makeUA() {
        String s = Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
        return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
    }

}