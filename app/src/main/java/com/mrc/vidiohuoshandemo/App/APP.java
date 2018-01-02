package com.mrc.vidiohuoshandemo.App;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

import static com.mrc.vidiohuoshandemo.api.HsConstants.APP_HUOSHAN_DOMAIN;
import static com.mrc.vidiohuoshandemo.api.HsConstants.HUOSHAN_DOMAIN_NAME;

/**
 * Created by 杨群 on 2017/12/29.
 */

public class APP extends Application{
    private static Context context;
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    public static Context getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        RetrofitUrlManager.getInstance().putDomain(HUOSHAN_DOMAIN_NAME, APP_HUOSHAN_DOMAIN);
        Fresco.initialize(this);
    }

    public static Context AppContext() {
        return context;
    }
}
