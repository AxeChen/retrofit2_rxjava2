package com.mg.axe.retrofit2_rxjava2.block;

import com.mg.axe.retrofit2_rxjava2.network.NetWorkManager;
import com.mg.axe.retrofit2_rxjava2.network.response.Response;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Zaifeng on 2018/3/1.
 */

public class MyCarModel implements MyCarContract.Model {
    @Override
    public Observable<Response<List<JavaBean>>> getCarList(String userId) {
        return NetWorkManager.getRequest().getList(userId);
    }
}
