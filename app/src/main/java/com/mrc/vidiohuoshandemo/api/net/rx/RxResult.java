package com.mrc.vidiohuoshandemo.api.net.rx;


import com.mrc.vidiohuoshandemo.common.BaseView;
import com.mrc.vidiohuoshandemo.entity.HttpResult;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by liqy on 2017/12/27.
 */

public  class RxResult {
    public static  <T> ObservableTransformer<HttpResult<T>, T> handleResult(BaseView view) {
        return new ObservableTransformer<HttpResult<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<HttpResult<T>> upstream) {
                return  upstream.flatMap(new Function<HttpResult<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(HttpResult<T> result) throws Exception {
                        if (result.isSuccess()) {
                            return createData(result.data);
                        } else if (!needHandleResult(result)) {
                            return Observable.error(new Exception(result.message));
                        }
                        return Observable.empty();
                    }
                });
            }
        };
    }

    private static boolean needHandleResult(HttpResult result) {
        return false;
    }

    private static  <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> subscriber) throws Exception {
                try {
                    subscriber.onNext(t);
                    subscriber.onComplete();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
