package com.mrc.vidiohuoshandemo.api;

import com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live.Livebean;
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
    //轮播图
    @GET("hotsoon/feed/?type=live&live_source=live_big_picture&min_time=0&offset=7&count=20&req_from=feed_refresh&live_sdk_version=300&iid=22011786718&device_id=39901824739&ac=wifi&channel=360&aid=1112&app_name=live_stream&version_code=300&version_name=3.0.0&device_platform=android&ssmix=a&device_type=2014811&device_brand=Xiaomi&language=zh&os_api=19&os_version=4.4.2&uuid=866048010542381&openudid=54ee7588ea182536&manifest_version_code=300&resolution=480*800&dpi=160&update_version_code=3003&_rticket=1514711700564&ts=1514711700&as=a2a54a34b469ea9a48&cp=aa9aa55d4e8545a1e2&mas=005f05d7bd059a5c71d8659b129f747ea44b40da17")
    Observable<Livebean> getNoParams();
}
