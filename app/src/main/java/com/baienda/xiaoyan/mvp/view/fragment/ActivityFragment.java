package com.baienda.xiaoyan.mvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.mvp.contract.ActivityContract;
import com.baienda.xiaoyan.mvp.presenter.ActivityPresenter;
import com.baienda.xiaoyan.recyclerview.CommonAdapter;
import com.baienda.xiaoyan.recyclerview.RecyclerViewDivider;
import com.baienda.xiaoyan.recyclerview.base.ViewHolder;
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
    private CommonAdapter activity_list_adapter;

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
        for (int i = 0; i < 40; i++) {
            activity_list_data.add(i);
        }
        activity_list_adapter = new CommonAdapter(getContext(), R.layout.item_activity_list, activity_list_data) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {

            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView) {
                super.onViewHolderCreated(holder, itemView);

            }
        };
        rv_activity_list.setAdapter(activity_list_adapter);
        rv_activity_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv_activity_list.addItemDecoration(new RecyclerViewDivider(false));
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_activity;
    }

    @Override
    public void onClick(View v) {

    }
}
