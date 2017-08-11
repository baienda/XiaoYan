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

    @BindView(R.id.rl_higher_view)
    RelativeLayout rl_higher_view;

    @Override
    public MePresenter createPresenter() {
        return new MePresenter();
    }

    @Override
    public void initEvent() {

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

    }
}
