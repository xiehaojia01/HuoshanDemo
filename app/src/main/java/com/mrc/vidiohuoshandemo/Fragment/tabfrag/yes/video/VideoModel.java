package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.video;

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


public class VideoModel implements IVidelModel {

    @Override
    public void videodata(final OnNetLinsenter<VideoBean_Sp> videoBeanOnNetLinsenter) {
        final ApiService apiService = RetrofitUtils.getInstance()
                .getApiService(API.Main, ApiService.class);
        Observable<VideoBean_Sp> params = apiService.videobean();
        params.subscribeOn(Schedulers.io())//指定IO做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//指定更新UI在主线程
                .subscribe(new Observer<VideoBean_Sp>() {

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
                    public void onNext(VideoBean_Sp bean) {//消费事件
                        Log.i("xxx", bean+"");
                        if (videoBeanOnNetLinsenter!=null){
                            videoBeanOnNetLinsenter.callBack(bean);
                        }
                    }
                });
    }
}
