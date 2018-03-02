package com.mg.axe.retrofit2_rxjava2.network.request;

import com.mg.axe.retrofit2_rxjava2.block.JavaBean;
import com.mg.axe.retrofit2_rxjava2.network.response.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Zaifeng on 2018/2/28.
 * 封装请求的接口
 */

public interface Request {

    public static String HOST = "https://xxxx.api.xxx.com/xxxx/";

    @POST("?service=User.getList")
    Observable<Response<List<JavaBean>>> getList(@Query("userId") String userId);

}
