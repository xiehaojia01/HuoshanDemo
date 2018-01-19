package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.thesamecity;

import android.util.Log;

import com.mrc.vidiohuoshandemo.api.ApiService;
import com.mrc.vidiohuoshandemo.api.RetrofitUtils;
import com.mrc.vidiohuoshandemo.api.net.API;
import com.mrc.vidiohuoshandemo.util.OnNetLinsenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SameCityModel implements ISameCityModel{
    @Override
    public void sameCitydata(final OnNetLinsenter<SameCityBean> videoBeanOnNetLinsenter) {
        final ApiService apiService = RetrofitUtils.getInstance()
                .getApiService(API.Main, ApiService.class);
        Observable<SameCityBean> params = apiService.sameCityBean();
        params.subscribeOn(Schedulers.io())//指定IO做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//指定更新UI在主线程
                .subscribe(new Observer<SameCityBean>() {
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
                    public void onNext(SameCityBean bean) {//消费事件
                        Log.i("xxx", bean+"");
                        if (videoBeanOnNetLinsenter!=null){
                            videoBeanOnNetLinsenter.callBack(bean);
                        }
                    }
                });

    }




}
