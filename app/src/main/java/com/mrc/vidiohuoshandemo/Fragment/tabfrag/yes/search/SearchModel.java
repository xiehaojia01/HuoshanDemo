package com.mrc.vidiohuoshandemo.Fragment.tabfrag.yes.search;

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

/**
 * Created by 杨群 on 2018/1/8.
 */

public class SearchModel implements ISearchModel {
    @Override
    public void searchData(final OnNetLinsenter<SearchBean> searchBeanOnNetLinsenter) {
        final ApiService apiService = RetrofitUtils.getInstance()
                .getApiService(API.Main, ApiService.class);
        Observable<SearchBean> params = apiService.getSearchs();
        params.subscribeOn(Schedulers.io())//指定IO做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//指定更新UI在主线程
                .subscribe(new Observer<SearchBean>() {

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
                    public void onNext(SearchBean searchBean) {
                        Log.i("xxx", searchBean+"");
                            searchBeanOnNetLinsenter.callBack(searchBean);
                    }
                });
                    }

}
