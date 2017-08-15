package com.baienda.xiaoyan.mvp.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.UserInfoContract;
import com.baienda.xiaoyan.mvp.presenter.UserInfoPresenter;
import com.baienda.xiaoyan.utils.img.PictureSelector;

import butterknife.BindView;

public class UserInfoActivity extends MVPBaseActivity<UserInfoPresenter> implements UserInfoContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_right)
    TextView tv_right;
    @BindView(R.id.tv_community)
    TextView tv_community;
    @BindView(R.id.tv_xiaoyan_account)
    TextView tv_xiaoyan_account;

    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_real_name)
    EditText et_real_name;

    @BindView(R.id.iv_left)
    ImageView iv_left;
    @BindView(R.id.iv_head)
    ImageView iv_head;

    @BindView(R.id.ll_head)
    LinearLayout ll_head;
    @BindView(R.id.ll_community)
    LinearLayout ll_community;
    @BindView(R.id.ll_my_qrcode)
    LinearLayout ll_my_qrcode;

    @Override
    public int setLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initEvent() {
        iv_left.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        ll_head.setOnClickListener(this);
        ll_community.setOnClickListener(this);
        ll_my_qrcode.setOnClickListener(this);
    }

    @Override
    public void init() {
        tv_title.setText(getString(R.string.userinfo));
    }

    @Override
    public UserInfoPresenter createPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_right:
                break;
            case R.id.ll_head:
                PictureSelector.selectImage(this);
                break;
            case R.id.ll_community:
                break;
            case R.id.ll_my_qrcode:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = PictureSelector.handleResult(this, requestCode, resultCode, data);
        iv_head.setImageBitmap(bitmap);
    }
}
