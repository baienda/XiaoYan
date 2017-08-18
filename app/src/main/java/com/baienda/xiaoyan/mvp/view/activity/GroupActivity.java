package com.baienda.xiaoyan.mvp.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.GroupContract;
import com.baienda.xiaoyan.mvp.presenter.GroupPresenter;

import butterknife.BindView;

public class GroupActivity extends MVPBaseActivity<GroupPresenter> implements GroupContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @Override
    public int setLayout() {
        return R.layout.activity_group;
    }

    @Override
    public void onActivityCreated() {
        tv_title.setText(getString(R.string.group));
        iv_left.setOnClickListener(this);

    }

    @Override
    public GroupPresenter createPresenter() {
        return new GroupPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
        }
    }
}
