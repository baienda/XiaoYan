package com.baienda.xiaoyan.mvp.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.NotificationContract;
import com.baienda.xiaoyan.mvp.presenter.NotificationPresenter;

import butterknife.BindView;

public class NotificationActivity extends MVPBaseActivity<NotificationPresenter> implements NotificationContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @Override
    public int setLayout() {
        return R.layout.activity_notification;
    }

    @Override
    public void onActivityCreated() {
        tv_title.setText(getString(R.string.notification));
        iv_left.setOnClickListener(this);

    }

    @Override
    public NotificationPresenter createPresenter() {
        return new NotificationPresenter();
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
