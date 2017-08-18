package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.MyOrderContract;
import com.baienda.xiaoyan.mvp.model.MyOrderModel;
import com.baienda.xiaoyan.mvp.view.activity.MyOrderActivity;

/**
 * Created by Serenade on 2017/8/14.
 */

public class MyOrderPresenter extends MVPBasePresenter<MyOrderActivity,MyOrderModel> implements MyOrderContract.Presenter{
    @Override
    public void start() {

    }
}
