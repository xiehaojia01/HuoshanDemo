package com.mrc.vidiohuoshandemo.api;

import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.thesamecity.SameCityBean;
import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video.VideoBean_Sp;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 杨群 on 2017/12/30.
 */

public interface ApiService {
//    @GET("hotsoon/feed/?type=live")
//    Observable<Livebean> getNoParams();
    @GET("hotsoon/feed/?type=video&min_time=0&count=20&req_from=enter_auto&live_sdk_version=273&iid=20058720887&device_id=39500980677&ac=wifi&channel=360&aid=1112&app_name=live_stream&version_code=273&version_name=2.7.3&device_platform=android&ssmix=a&device_type=GT-P5210&device_brand=samsung&os_api=19&os_version=4.4.4&uuid=865854081230173&openudid=4058040115108878&manifest_version_code=273&resolution=480*800&dpi=128&update_version_code=2732&ts=1513384710&as=a235f643b670ca1b74&cp=6206ab58694835b0e2")
    Observable<VideoBean_Sp> videobean();
    @GET("hotsoon/feed/?type=city")
    Observable<SameCityBean> sameCityBean();
}
