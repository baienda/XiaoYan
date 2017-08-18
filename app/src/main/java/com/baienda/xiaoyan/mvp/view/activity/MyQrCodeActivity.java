package com.baienda.xiaoyan.mvp.view.activity;

import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.MyQrCodeContract;
import com.baienda.xiaoyan.mvp.presenter.MyQrCodePresenter;

public class MyQrCodeActivity extends MVPBaseActivity<MyQrCodePresenter> implements MyQrCodeContract.View {

    @Override
    public int setLayout() {
        return R.layout.activity_my_qr_code;
    }

    @Override
    public void onActivityCreated() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public MyQrCodePresenter createPresenter() {
        return new MyQrCodePresenter();
    }
}
