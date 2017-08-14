package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.ActivityContract;
import com.baienda.xiaoyan.mvp.view.fragment.ActivityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XY02 on 2017/8/10.
 */

public class ActivityPresenter extends MVPBasePresenter<ActivityFragment> implements ActivityContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 100; i++) {
            data.add(i);
        }
        mView.setActivityData(data);
    }
}
