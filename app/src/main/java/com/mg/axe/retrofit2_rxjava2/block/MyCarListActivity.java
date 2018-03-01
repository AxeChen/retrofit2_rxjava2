package com.mg.axe.retrofit2_rxjava2.block;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mg.axe.retrofit2_rxjava2.R;
import com.mg.axe.retrofit2_rxjava2.network.schedulers.SchedulerProvider;

/**
 * Created by Zaifeng on 2018/3/1.
 */

public class MyCarListActivity extends AppCompatActivity implements MyCarContract.View {

    private MyCarPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        presenter = new MyCarPresenter(new MyCarModel(), this, SchedulerProvider.getInstance());
    }

    public void btnRequest(View view) {
        presenter.getCarList();
    }
}
