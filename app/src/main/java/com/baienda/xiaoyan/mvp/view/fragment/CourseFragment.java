package com.baienda.xiaoyan.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.HotCoursesAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.mvp.contract.CourseContract;
import com.baienda.xiaoyan.mvp.presenter.CoursePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by XY02 on 2017/8/10.
 */

public class CourseFragment extends MVPBaseFragment<CoursePresenter> implements CourseContract.View, OnLoadmoreListener, OnRefreshListener {
    @BindView(R.id.rv_hot_courses)
    RecyclerView rv_hot_courses;

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smart_refresh_layout;

    private HotCoursesAdapter hot_courses_adapter;
    private List hot_courses_data;

    @Override
    public CoursePresenter createPresenter() {
        return new CoursePresenter();
    }

    @Override
    public void initEvent() {
        smart_refresh_layout.setOnLoadmoreListener(this);
        smart_refresh_layout.setOnRefreshListener(this);
    }

    @Override
    public void init() {
        smart_refresh_layout.setEnableAutoLoadmore(false);
        hot_courses_data = new ArrayList();
        hot_courses_adapter = new HotCoursesAdapter(getContext(), R.layout.item_hot_courses, hot_courses_data);
        rv_hot_courses.setAdapter(hot_courses_adapter);
        rv_hot_courses.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_hot_courses.setNestedScrollingEnabled(false);

        mPresenter.start();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_course;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setCourseData(List data) {
        hot_courses_data.clear();
        hot_courses_data.addAll(data);
        hot_courses_adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        refreshlayout.finishLoadmore(1000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        refreshlayout.finishRefresh(1000);
    }
}
