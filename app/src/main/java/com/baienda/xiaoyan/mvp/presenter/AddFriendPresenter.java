package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.AddFriendContract;
import com.baienda.xiaoyan.mvp.model.AddFriendModel;
import com.baienda.xiaoyan.mvp.view.activity.AddFriendActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class AddFriendPresenter extends MVPBasePresenter<AddFriendActivity,AddFriendModel> implements AddFriendContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add(i);
        }
        mView.setUserListData(data);
    }
}
