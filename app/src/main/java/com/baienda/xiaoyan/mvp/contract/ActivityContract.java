package com.baienda.xiaoyan.mvp.contract;

import com.baienda.xiaoyan.base.mvpbase.BaseContract;

import java.util.List;

/**
 * Created by XY02 on 2017/8/10.
 */

public interface ActivityContract {
    interface View extends BaseContract.View {
        void setActivityData(List data);
    }

    interface Presenter extends BaseContract.Presenter {

    }
}
