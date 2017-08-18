package com.baienda.xiaoyan.mvp.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.MyOrderContract;
import com.baienda.xiaoyan.mvp.presenter.MyOrderPresenter;

import butterknife.BindView;

/**
 * Created by Serenade on 2017/8/14.
 */

public class MyOrderActivity extends MVPBaseActivity<MyOrderPresenter> implements MyOrderContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @BindView(R.id.tl_tabs)
    TabLayout tl_tabs;
    @BindView(R.id.vp_order)
    ViewPager vp_order;

    @Override
    public MyOrderPresenter createPresenter() {
        return new MyOrderPresenter();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_my_order;
    }

    @Override
    public void onActivityCreated() {
        tv_title.setText(getString(R.string.my_order));
        iv_left.setOnClickListener(this);


        tl_tabs.addTab(tl_tabs.newTab().setText("购买成功"),true);
        tl_tabs.addTab(tl_tabs.newTab().setText("未支付"));
        tl_tabs.addTab(tl_tabs.newTab().setText("已失效"));
        tl_tabs.setupWithViewPager(vp_order);
//        vp_order.setAdapter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_left:
                finish();
                break;
        }
    }
}
