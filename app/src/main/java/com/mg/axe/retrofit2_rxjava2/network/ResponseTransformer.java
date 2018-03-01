package com.mg.axe.retrofit2_rxjava2.network;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by Zaifeng on 2018/2/28.
 * 对返回的数据进行处理，区分异常的情况。
 */

public class ResponseTransformer {

    public static <T> ObservableTransformer<Response<T>, T> handleResult() {
        return new ObservableTransformer<Response<T>, T>() {

            @Override
            public ObservableSource<T> apply(Observable<Response<T>> upstream) {
                return upstream
                        .flatMap(new Function<Response<T>, ObservableSource<T>>() {
                            @Override
                            public ObservableSource<T> apply(Response<T> tResponse) throws Exception {
                                int code = tResponse.getCode();
                                String message = tResponse.getMsg();
                                if (code == 200) {
                                    return Observable.just(tResponse.getData());
                                } else {
                                    return Observable.error(new ApiException(code, message));
                                }
                            }
                        });
            }
        };
    }


    /**
     * 非服务其返回的异常，比如：无网络链接的情况
     *
     * @param <T>
     */
    private static class ErrorFunction<T> implements Function<Throwable, ObservableSource<? extends Response<T>>> {

        @Override
        public ObservableSource<Response<T>> apply(Throwable throwable) throws Exception {

            return null;
        }
    }


    /**
     * 服务其返回的数据解析
     *
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<Response<T>, T> {

        @Override
        public T apply(Response<T> tResponse) throws Exception {
            if (tResponse.getCode() != 200) {
                // 如果不是

            }
            return tResponse.getData();
        }
    }


}
