package com.mg.axe.retrofit2_rxjava2.block;

import android.util.Log;

import com.mg.axe.retrofit2_rxjava2.network.RequestManager;
import com.mg.axe.retrofit2_rxjava2.network.Response;
import com.mg.axe.retrofit2_rxjava2.network.ResponseTransformer;
import com.mg.axe.retrofit2_rxjava2.network.schedulers.BaseSchedulerProvider;
import com.mg.axe.retrofit2_rxjava2.network.schedulers.SchedulerProvider;

import java.util.List;

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
        Disposable disposable = model.getCarList("7039887")
                .compose(ResponseTransformer.handleResult())
                .compose(schedulerProvider.applySchedulers())
                .subscribe(carBeans -> {
                    List<CarBean> carBeans1 = carBeans;
                    Log.i("sdfsdf",carBeans.toString());
                }, throwable -> {
                });
        mDisposable.add(disposable);
    }

}
