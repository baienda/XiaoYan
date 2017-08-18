package com.baienda.xiaoyan.mvp.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.MyActivityContract;
import com.baienda.xiaoyan.mvp.presenter.MyActivityPresenter;

import butterknife.BindView;

public class MyActivityActivity extends MVPBaseActivity<MyActivityPresenter> implements MyActivityContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @Override
    public int setLayout() {
        return R.layout.activity_my_activity;
    }

    @Override
    public void onActivityCreated() {
        tv_title.setText(getString(R.string.my_activity));
        iv_left.setOnClickListener(this);


    }

    @Override
    public MyActivityPresenter createPresenter() {
        return new MyActivityPresenter();
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
