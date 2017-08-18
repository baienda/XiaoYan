package com.baienda.xiaoyan.mvp.view.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.BaseActivity;

import butterknife.BindView;

public class NotificationSettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @BindView(R.id.ll_receive_new_notification)
    LinearLayout ll_receive_new_notification;
    @BindView(R.id.ll_voice)
    LinearLayout ll_voice;
    @BindView(R.id.ll_shake)
    LinearLayout ll_shake;

    @BindView(R.id.cb_receive_new_notification)
    CheckBox cb_receive_new_notification;
    @BindView(R.id.cb_voice)
    CheckBox cb_voice;
    @BindView(R.id.cb_shake)
    CheckBox cb_shake;

    @Override
    public int setLayout() {
        return R.layout.activity_notification_setting;
    }

    @Override
    public void onActivityCreated() {
        tv_title.setText(getString(R.string.notification_setting));
        iv_left.setOnClickListener(this);
        ll_receive_new_notification.setOnClickListener(this);
        ll_voice.setOnClickListener(this);
        ll_shake.setOnClickListener(this);

        cb_receive_new_notification.setOnCheckedChangeListener(this);
        cb_voice.setOnCheckedChangeListener(this);
        cb_shake.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.ll_receive_new_notification:
                cb_receive_new_notification.setChecked(!cb_receive_new_notification.isChecked());
                break;
            case R.id.ll_voice:
                cb_voice.setChecked(!cb_voice.isChecked());
                break;
            case R.id.ll_shake:
                cb_shake.setChecked(!cb_shake.isChecked());
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_receive_new_notification:
                break;
            case R.id.cb_voice:
                break;
            case R.id.cb_shake:
                break;
        }
    }
}
