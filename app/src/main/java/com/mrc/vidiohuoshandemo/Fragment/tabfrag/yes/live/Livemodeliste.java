package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.live;

import android.util.Log;

import com.mrc.vidiohuoshandemo.api.ApiService;
import com.mrc.vidiohuoshandemo.api.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */

public class Livemodeliste implements Livemodel {
    @Override
    public void getData(final LiveFinishListener listener) {
        ApiService apiService = RetrofitUtils.getInstance().getApiService("https://hotsoon.snssdk.com/", ApiService.class);
        Observable<Livebean> params = apiService.getNoParams();
        params.subscribeOn(Schedulers.io())//指定IO做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//指定更新UI在主线程
                .subscribe(new Observer<Livebean>() {
                    @Override
                    public void onError(Throwable e) {//失败
                        Log.i("x", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Livebean livebean) {//消费事件
                        Log.i("xxx", livebean+"");
                       if (listener!=null){
                           listener.onSuccess(livebean);
                       }
                    }
                });
    }
}
