package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.NewFriendContract;
import com.baienda.xiaoyan.mvp.model.NewFriendModel;
import com.baienda.xiaoyan.mvp.view.activity.NewFriendActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class NewFriendPresenter extends MVPBasePresenter<NewFriendActivity,NewFriendModel> implements NewFriendContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add(i);
        }
        mView.setFriendRequestData(data);
    }
}
