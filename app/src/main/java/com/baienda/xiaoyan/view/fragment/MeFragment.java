package com.baienda.xiaoyan.view.fragment;

import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.contract.MeContract;
import com.baienda.xiaoyan.presenter.MePresenter;

/**
 * Created by XY02 on 2017/8/10.
 */

public class MeFragment extends MVPBaseFragment<MePresenter> implements MeContract.View {
    @Override
    public MePresenter createPresenter() {
        return new MePresenter();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void init() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void onClick(View v) {

    }
}
