package com.baienda.xiaoyan.mvp.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.HotCategoriesAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.mvp.contract.VideoContract;
import com.baienda.xiaoyan.mvp.presenter.VideoPresenter;
import com.baienda.xiaoyan.widget.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by XY02 on 2017/8/10.
 */

public class VideoFragment extends MVPBaseFragment<VideoPresenter> implements VideoContract.View, OnLoadmoreListener, OnRefreshListener {
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smart_refresh_layout;

    @BindView(R.id.rv_hot_categories)
    RecyclerView rv_hot_categories;

    @BindView(R.id.banner)
    Banner banner;

    private HotCategoriesAdapter hot_categories_adapter;
    private List hot_categories_data;

    @Override
    public VideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void onViewCreated() {
        smart_refresh_layout.setOnLoadmoreListener(this);
        smart_refresh_layout.setOnRefreshListener(this);
        smart_refresh_layout.setEnableAutoLoadmore(false);

        hot_categories_data = new ArrayList();
        hot_categories_adapter = new HotCategoriesAdapter(getContext(), R.layout.item_hot_categories, hot_categories_data);
        rv_hot_categories.setAdapter(hot_categories_adapter);
        rv_hot_categories.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rv_hot_categories.setNestedScrollingEnabled(false);

        List images = new ArrayList();
        for (int i = 0; i < 10; i++) {
            images.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1502429896&di=11431897c45caa6a2bbb679a24ee3f22&src=http://image91.360doc.com/DownloadImg/2015/11/0923/61335255_28.jpg");
        }

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置banner指示器样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

        mPresenter.start();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setVideoData(List data) {
        hot_categories_data.clear();
        hot_categories_data.addAll(data);
        hot_categories_adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
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
