package com.baienda.xiaoyan.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.contract.VideoContract;
import com.baienda.xiaoyan.presenter.VideoPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

/**
 * Created by XY02 on 2017/8/10.
 */

public class VideoFragment extends MVPBaseFragment<VideoPresenter> implements VideoContract.View, OnLoadmoreListener, OnRefreshListener {
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smart_refresh_layout;
    @BindView(R.id.rv_categories)
    RecyclerView rv_categories;

    @Override
    public VideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void initEvent() {
        smart_refresh_layout.setOnLoadmoreListener(this);
        smart_refresh_layout.setOnRefreshListener(this);
    }

    @Override
    public void init() {
//        rv_categories.setAdapter(null);
//        rv_categories.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        showLoadingDialog();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void onClick(View v) {

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
