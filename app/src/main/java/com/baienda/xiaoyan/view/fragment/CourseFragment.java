package com.baienda.xiaoyan.view.fragment;

import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.contract.CourseContract;
import com.baienda.xiaoyan.presenter.CoursePresenter;

/**
 * Created by XY02 on 2017/8/10.
 */

public class CourseFragment extends MVPBaseFragment<CoursePresenter> implements CourseContract.View {
    @Override
    public CoursePresenter createPresenter() {
        return new CoursePresenter();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void init() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_course;
    }

    @Override
    public void onClick(View v) {

    }
}
