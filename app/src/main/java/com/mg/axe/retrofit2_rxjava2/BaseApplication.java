package com.mg.axe.retrofit2_rxjava2;

import android.app.Application;

import com.mg.axe.retrofit2_rxjava2.network.NetWorkManager;

/**
 * Created by Zaifeng on 2018/3/1.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkManager.getInstance().init();
    }
}
