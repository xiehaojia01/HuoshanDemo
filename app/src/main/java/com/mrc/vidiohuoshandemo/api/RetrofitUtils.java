package com.mrc.vidiohuoshandemo.api;

import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.LoggingInterceptor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Lenovo
 * @date 2017/12/28
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private RetrofitUtils(){

    }
    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    private static Retrofit retrofit;
    public static synchronized Retrofit getRetrofit(String url){


        LoggingInterceptor httpLoggingInterceptor =new LoggingInterceptor();
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(500, TimeUnit.SECONDS)
                .readTimeout(500,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public <T>T getApiService(String url,Class<T> cl){
        //得到retrofit
        Retrofit retrofit = getRetrofit(url);

        //返回的就是网络接口对象
        return retrofit.create(cl);

    }


}

