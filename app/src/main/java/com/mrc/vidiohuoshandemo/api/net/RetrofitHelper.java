package com.mrc.vidiohuoshandemo.api.net;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.mrc.vidiohuoshandemo.BuildConfig;
import com.mrc.vidiohuoshandemo.api.HuoShanApi;
import com.mrc.vidiohuoshandemo.api.SnsApi;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mrc.vidiohuoshandemo.api.HsConstants.API_HOST;

/**
 * Created by 杨群 on 2017/12/29.
 */

public class RetrofitHelper {
    private static Retrofit retrofit;
    static{
        initRetrofit(API_HOST);
    }
    /**
     * 获取OkHttpClient
     *
     * @return
     */
    private static OkHttpClient getOkHttpClient(){
        //TODO 处理拦截器，自定义缓存，HTTP的一些参数设置
        OkHttpClient.Builder builder = RetrofitUrlManager
                .getInstance()
                .with(new OkHttpClient.Builder());
        //只有再开发版本才打印log日志
        if(BuildConfig.DEBUG){
            //TODO 日志拦截器
            builder.addInterceptor(new LoggingInterceptor.Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                            .tag("huoshan")
                            .request("Request")
                             .response("Response")
                    .addHeader("version", BuildConfig.VERSION_NAME)
                    .build());
        }


        return builder.build();
    }
    //单例懒汉模式封装
    private static void initRetrofit(String url) {
        if (retrofit == null) {
            synchronized (Retrofit.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
    }
    public static HuoShanApi getHuoShanAPI() {
        return createAPI(HuoShanApi.class);
    }
    public static SnsApi getSNSAPI() {
        return createAPI(SnsApi.class);
    }

    private static <T> T createAPI(Class<T> clzss) {
        return retrofit.create(clzss);
    }
}
