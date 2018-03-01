package com.mg.axe.retrofit2_rxjava2.network;

import com.mg.axe.retrofit2_rxjava2.block.CarBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Zaifeng on 2018/2/28.
 * 封装请求的接口
 */

public interface ApiService {

    public static String HOST = "https://prod.api.ybzg.com/app_v5/";

    /**
     * 我的车辆-车辆列表
     *
     * @param userId 用户ID
     * @return
     */
    @POST("?service=User.getCarList")
    Observable<Response<List<CarBean>>> getCarList(@Query("userId") String userId);

}
