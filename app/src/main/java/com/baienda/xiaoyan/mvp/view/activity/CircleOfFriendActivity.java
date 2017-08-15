package com.baienda.xiaoyan.mvp.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.CircleOfFriendContract;
import com.baienda.xiaoyan.mvp.presenter.CircleOfFriendPresenter;

import butterknife.BindView;

public class CircleOfFriendActivity extends MVPBaseActivity<CircleOfFriendPresenter> implements CircleOfFriendContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;
    @BindView(R.id.iv_right)
    ImageView iv_right;

    @Override
    public int setLayout() {
        return R.layout.activity_circle_of_friend;
    }

    @Override
    public void initEvent() {
        iv_left.setOnClickListener(this);
    }

    @Override
    public void init() {
        tv_title.setText(getString(R.string.circle_of_friends));
        iv_right.setVisibility(View.VISIBLE);

    }

    @Override
    public CircleOfFriendPresenter createPresenter() {
        return new CircleOfFriendPresenter();
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
