package com.baienda.xiaoyan.mvp.contract;

import com.baienda.xiaoyan.base.mvpbase.BaseContract;

import java.util.List;

/**
 * Created by Serenade on 2017/8/14.
 */

public interface NewFriendContract {
    interface View extends BaseContract.View{
        void setFriendRequestData(List data);
    }
    interface Presenter extends BaseContract.Presenter{

    }
}
