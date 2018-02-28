package com.mg.axe.retrofit2_rxjava2.network;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by Zaifeng on 2018/2/28.
 * 对返回的值进行分类处理
 */

public class ResponseTransformer {

    public static <T> ObservableTransformer<ResponseBean<T>, T> handleResult() {
//        return new ObservableTransformer<ResponseBean<T>, T>() {
//            @Override
//            public ObservableSource<T> apply(Observable<ResponseBean<T>> upstream) {
//
//                return upstream.onErrorResumeNext(new Function<Throwable, ObservableSource<? extends ResponseBean<T>>>() {
//                    @Override
//                    public ObservableSource<? extends ResponseBean<T>> apply(Throwable throwable) throws Exception {
//                        return null;
//                    }
//                }).map(new ResponseFunction<T>());
//            }
//        }

        return null;
    }

    private static class ExceptionFunction<T> implements Function<Throwable, ObservableSource<? extends ResponseBean<T>> {


        @Override
        public ObservableSource<ResponseBean<T>> apply(Throwable throwable) throws Exception {
            return null;
        }
    }


    private static class ResponseFunction<T> implements Function<ResponseBean<T>, T> {

        @Override
        public T apply(ResponseBean<T> tResponseBean) throws Exception {
            return null;
        }
    }


}
