package com.baienda.xiaoyan.mvp.contract;

import com.baienda.xiaoyan.base.mvpbase.BaseContract;

import java.util.List;

/**
 * Created by Serenade on 2017/8/14.
 */

public interface CategoryInfoContract {
    interface View extends BaseContract.View{
        void setCategoryInfoData(List data);
    }
    interface Presenter extends BaseContract.Presenter{

    }
}
