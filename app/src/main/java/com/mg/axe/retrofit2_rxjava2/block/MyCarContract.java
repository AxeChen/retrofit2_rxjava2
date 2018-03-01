package com.mg.axe.retrofit2_rxjava2.block;

import com.mg.axe.retrofit2_rxjava2.network.Response;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Zaifeng on 2018/3/1.
 */

public class MyCarContract {

    public interface Persenter {
        public void getCarList(String userId);
    }

    public interface View {

    }

    public interface Model {
        public Observable<Response<List<CarBean>>> getCarList(String userId);
    }

}
