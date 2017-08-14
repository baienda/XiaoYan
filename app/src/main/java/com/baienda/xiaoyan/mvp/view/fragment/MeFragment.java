package com.baienda.xiaoyan.mvp.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.mvp.contract.MeContract;
import com.baienda.xiaoyan.mvp.presenter.MePresenter;
import com.baienda.xiaoyan.mvp.view.activity.CircleOfFriendActivity;
import com.baienda.xiaoyan.mvp.view.activity.MyActivityActivity;
import com.baienda.xiaoyan.mvp.view.activity.MyOrderActivity;
import com.baienda.xiaoyan.mvp.view.activity.NotificationActivity;
import com.baienda.xiaoyan.widget.HeadZoomScrollView;

import butterknife.BindView;

/**
 * Created by XY02 on 2017/8/10.
 */

public class MeFragment extends MVPBaseFragment<MePresenter> implements MeContract.View {
    @BindView(R.id.head_zoom_scrollview)
    HeadZoomScrollView head_zoom_scrollview;

    @BindView(R.id.iv_bg)
    ImageView iv_bg;
    @BindView(R.id.iv_head)
    ImageView iv_head;

    @BindView(R.id.tv_sign)
    TextView tv_sign;
    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.tv_description)
    TextView tv_description;

    @BindView(R.id.ll_service_time)
    LinearLayout ll_service_time;
    @BindView(R.id.ll_amount_of_jewel)
    LinearLayout ll_amount_of_jewel;
    @BindView(R.id.ll_money_of_xiaoyan)
    LinearLayout ll_money_of_xiaoyan;
    @BindView(R.id.ll_my_order)
    LinearLayout ll_my_order;
    @BindView(R.id.ll_my_activity)
    LinearLayout ll_my_activity;
    @BindView(R.id.ll_chat)
    LinearLayout ll_chat;
    @BindView(R.id.ll_circle_of_friends)
    LinearLayout ll_circle_of_friends;
    @BindView(R.id.ll_notification)
    LinearLayout ll_notification;
    @BindView(R.id.ll_service_team)
    LinearLayout ll_service_team;

    @BindView(R.id.rl_higher_view)
    RelativeLayout rl_higher_view;

    @Override
    public MePresenter createPresenter() {
        return new MePresenter();
    }

    @Override
    public void initEvent() {
        ll_my_order.setOnClickListener(this);
        ll_my_activity.setOnClickListener(this);
        ll_chat.setOnClickListener(this);
        ll_circle_of_friends.setOnClickListener(this);
        ll_notification.setOnClickListener(this);
        ll_service_team.setOnClickListener(this);
    }

    @Override
    public void init() {
        head_zoom_scrollview.setZoomView(iv_bg);
        head_zoom_scrollview.setHigherView(rl_higher_view);
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_my_order:
                startActivity(MyOrderActivity.class);
                break;
            case R.id.ll_my_activity:
                startActivity(MyActivityActivity.class);
                break;
            case R.id.ll_chat:
                break;
            case R.id.ll_circle_of_friends:
                startActivity(CircleOfFriendActivity.class);
                break;
            case R.id.ll_notification:
                startActivity(NotificationActivity.class);
                break;
            case R.id.ll_service_team:
                break;
        }
    }
}
