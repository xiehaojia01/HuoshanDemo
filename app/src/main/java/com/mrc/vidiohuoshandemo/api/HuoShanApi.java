package com.mrc.vidiohuoshandemo.api;

import com.mrc.vidiohuoshandemo.entity.HttpResultExtra;
import com.mrc.vidiohuoshandemo.entity.LiveExtra;
import com.mrc.vidiohuoshandemo.entity.LiveFeed;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static com.mrc.vidiohuoshandemo.api.HsConstants.HUOSHAN_DOMAIN_NAME;
import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public interface HuoShanApi {
    //header头部名称+火山的名称
//header头部名称+火山的名称
    @Headers(DOMAIN_NAME_HEADER + HUOSHAN_DOMAIN_NAME)
    @GET("hotsoon/feed/?type=live")
    public Observable<HttpResultExtra<ArrayList<LiveFeed>, LiveExtra>> liveFeed();

}
