package com.mg.axe.retrofit2_rxjava2.block;

import com.mg.axe.retrofit2_rxjava2.network.response.Response;
import com.mg.axe.retrofit2_rxjava2.network.response.ResponseTransformer;
import com.mg.axe.retrofit2_rxjava2.network.schedulers.BaseSchedulerProvider;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Zaifeng on 2018/3/1.
 */

public class MyCarPresenter {

    private MyCarModel model;

    private MyCarContract.View view;

    private BaseSchedulerProvider schedulerProvider;

    private CompositeDisposable mDisposable;

    public MyCarPresenter(MyCarModel model,
                          MyCarContract.View view,
                          BaseSchedulerProvider schedulerProvider) {
        this.model = model;
        this.view = view;
        this.schedulerProvider = schedulerProvider;
        mDisposable = new CompositeDisposable();

    }

    public void getCarList() {

        Disposable disposable = model.getCarList("xxxxxx")
                .compose(ResponseTransformer.handleResult())
                .compose(schedulerProvider.applySchedulers())
                .subscribe(carBeans -> {
                    // 处理数据 直接获取到List<JavaBean> carBeans
                }, throwable -> {
                    // 处理异常
                });

        mDisposable.add(disposable);
    }

}
