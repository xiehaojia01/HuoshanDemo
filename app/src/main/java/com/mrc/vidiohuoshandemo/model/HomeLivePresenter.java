package com.mrc.vidiohuoshandemo.model;

import android.util.Log;

import com.mrc.vidiohuoshandemo.api.net.RetrofitHelper;
import com.mrc.vidiohuoshandemo.api.net.rx.RxResult;
import com.mrc.vidiohuoshandemo.api.net.rx.RxSchedulers;
import com.mrc.vidiohuoshandemo.entity.HttpResult;
import com.mrc.vidiohuoshandemo.entity.Splash;

import io.reactivex.functions.Consumer;

/**
 * Created by 杨群 on 2017/12/29.
 */

public class HomeLivePresenter implements HomeLiveContract.Presenter {
    private HomeLiveContract.View liveView;
    public HomeLivePresenter(HomeLiveContract.View liveView) {

        this.liveView = liveView;
        liveView.setPresenter(this);
    }
    public void splash() {
        RetrofitHelper.getSNSAPI().splash()
                //TODO 线程调度
                .compose(RxSchedulers.<HttpResult<Splash>>io_main())
                .compose(RxResult.<Splash>handleResult(liveView))
                .subscribe(new Consumer<Splash>() {
                    @Override
                    public void accept(Splash splash) throws Exception {

                        //TODO 就可以直接使用
                        Log.d(getClass().getSimpleName(),splash.toString());

                    }
                });

    }

    @Override
    public void subscribe() {
        splash();
        liveView.showTitle();
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public String getTitle() {
        return "直播";
    }


}
