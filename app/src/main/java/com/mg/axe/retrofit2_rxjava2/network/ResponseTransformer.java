package com.mg.axe.retrofit2_rxjava2.network;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by Zaifeng on 2018/2/28.
 * 对返回的值进行分类处理
 */

public class ResponseTransformer {

    public static <T> ObservableTransformer<ResponseBean<T>, T> handleResult() {
        return new ObservableTransformer<ResponseBean<T>, T>() {

            @Override
            public ObservableSource<T> apply(Observable<ResponseBean<T>> upstream) {
                return upstream
                        .onErrorResumeNext(new ErrorFunction<T>())
                        .flatMap(new Function<ResponseBean<T>, ObservableSource<T>>() {
                            @Override
                            public ObservableSource<T> apply(ResponseBean<T> tResponseBean) throws Exception {
                                int code = tResponseBean.getCode();
                                String message = tResponseBean.getMsg();
                                if (code == 200) {
                                    return Observable.just(tResponseBean.getData());
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
    private static class ErrorFunction<T> implements Function<Throwable, ObservableSource<? extends ResponseBean<T>>> {

        @Override
        public ObservableSource<ResponseBean<T>> apply(Throwable throwable) throws Exception {
            return null;
        }
    }


    /**
     * 服务其返回的数据解析
     *
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<ResponseBean<T>, T> {

        @Override
        public T apply(ResponseBean<T> tResponseBean) throws Exception {
            if (tResponseBean.getCode() != 200) {
                // 如果不是

            }
            return tResponseBean.getData();
        }
    }


}
