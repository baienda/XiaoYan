package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.ChatContract;
import com.baienda.xiaoyan.mvp.model.ChatModel;
import com.baienda.xiaoyan.mvp.view.activity.ChatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serenade on 2017/8/15.
 */

public class ChatPresenter extends MVPBasePresenter<ChatActivity,ChatModel> implements ChatContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add(i);
        }
        mView.setChatData(data);
        mView.setAddressListData(data);
    }
}
