package com.mrc.vidiohuoshandemo.api;


import com.mrc.vidiohuoshandemo.entity.HttpResult;
import com.mrc.vidiohuoshandemo.entity.Splash;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by liqy on 2017/12/26.
 */

public interface SnsApi {

    @GET("api/ad/splash/live_stream/v14/")
    public Observable<HttpResult<Splash>> splash();

}
