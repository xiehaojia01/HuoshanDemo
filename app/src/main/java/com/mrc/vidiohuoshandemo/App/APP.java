package com.mrc.vidiohuoshandemo.App;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

import static com.mrc.vidiohuoshandemo.api.HsConstants.APP_HUOSHAN_DOMAIN;
import static com.mrc.vidiohuoshandemo.api.HsConstants.HUOSHAN_DOMAIN_NAME;

/**
 * Created by 杨群 on 2017/12/29.
 */

public class APP extends Application{
    public static APP app;

    public static Context getAppContext() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        RetrofitUrlManager.getInstance().putDomain(HUOSHAN_DOMAIN_NAME, APP_HUOSHAN_DOMAIN);
        Fresco.initialize(this);
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        UMShareAPI.get(this);
    }
}
