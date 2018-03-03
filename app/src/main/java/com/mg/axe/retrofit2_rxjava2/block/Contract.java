package com.mg.axe.retrofit2_rxjava2.block;

import com.mg.axe.retrofit2_rxjava2.bean.JavaBean;
import com.mg.axe.retrofit2_rxjava2.network.response.Response;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Zaifeng on 2018/3/1.
 */

public class Contract {

    public interface Persenter {
        public void getCarList(String userId);
    }

    public interface View {
        void getDataSuccess();
        void getDataFail();
    }

    public interface Model {
        public Observable<Response<List<JavaBean>>> getCarList(String userId);
    }

}
