package com.baienda.xiaoyan.base.mvpbase;

import android.os.Bundle;

import com.baienda.xiaoyan.base.BaseActivity;

/**
 * Created by admin on 2016/11/1.
 */
public abstract class MVPBaseActivity<T extends MVPBasePresenter> extends BaseActivity implements BaseContract.View {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
        super.onDestroy();
    }


    public abstract T createPresenter();

}


