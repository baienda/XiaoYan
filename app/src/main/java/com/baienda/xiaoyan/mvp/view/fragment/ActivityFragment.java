package com.baienda.xiaoyan.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.ActivityListAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.mvp.contract.ActivityContract;
import com.baienda.xiaoyan.mvp.presenter.ActivityPresenter;
import com.baienda.xiaoyan.recyclerview.RecyclerViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by XY02 on 2017/8/10.
 */

public class ActivityFragment extends MVPBaseFragment<ActivityPresenter> implements ActivityContract.View {
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smart_refresh_layout;

    @BindView(R.id.rv_activity_list)
    RecyclerView rv_activity_list;

    private List activity_list_data;
    private ActivityListAdapter activity_list_adapter;

    @Override
    public ActivityPresenter createPresenter() {
        return new ActivityPresenter();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void init() {
        activity_list_data = new ArrayList();
        activity_list_adapter = new ActivityListAdapter(getContext(), R.layout.item_activity_list, activity_list_data);
        rv_activity_list.setAdapter(activity_list_adapter);
        rv_activity_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv_activity_list.addItemDecoration(new RecyclerViewDivider(false));

        mPresenter.start();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_activity;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setActivityData(List data) {
        activity_list_data.clear();
        activity_list_data.addAll(data);
        activity_list_adapter.notifyDataSetChanged();
    }
}
