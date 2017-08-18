package com.baienda.xiaoyan.mvp.view.activity;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.ChangePasswordContract;
import com.baienda.xiaoyan.mvp.presenter.ChangePasswordPresenter;

import butterknife.BindView;

/**
 * Created by Serenade on 2017/8/16.
 */

public class ChangePasswordActivity extends MVPBaseActivity<ChangePasswordPresenter> implements ChangePasswordContract.View, CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_confirm_password)
    EditText et_confirm_password;

    @BindView(R.id.cb_password)
    CheckBox cb_password;
    @BindView(R.id.cb_confirm_password)
    CheckBox cb_confirm_password;

    @BindView(R.id.btn_complete)
    Button btn_complete;

    @Override
    public ChangePasswordPresenter createPresenter() {
        return new ChangePasswordPresenter();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_change_password;
    }

    @Override
    public void onActivityCreated() {
        iv_left.setOnClickListener(this);
        btn_complete.setOnClickListener(this);

        cb_password.setOnCheckedChangeListener(this);
        cb_confirm_password.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.btn_complete:
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_password:
                changePasswordVisibility(et_password, isChecked);
                et_password.setSelection(et_password.getText().toString().length());
                break;
            case R.id.cb_confirm_password:
                changePasswordVisibility(et_confirm_password, isChecked);
                et_confirm_password.setSelection(et_confirm_password.getText().toString().length());
                break;
        }
    }

    //设置EditText文本是否可见
    private void changePasswordVisibility(EditText editText, boolean visible) {
        if (visible)
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        else
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
}
