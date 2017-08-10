package com.baienda.xiaoyan.view.fragment;

import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.contract.ActivityContract;
import com.baienda.xiaoyan.presenter.ActivityPresenter;

/**
 * Created by XY02 on 2017/8/10.
 */

public class ActivityFragment extends MVPBaseFragment<ActivityPresenter> implements ActivityContract.View {
    @Override
    public ActivityPresenter createPresenter() {
        return new ActivityPresenter();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void init() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_activity;
    }

    @Override
    public void onClick(View v) {

    }
}
