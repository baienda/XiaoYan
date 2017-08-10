package com.baienda.xiaoyan.base.mvpbase;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baienda.xiaoyan.base.BaseFragment;


/**
 * Created by admin on 2016/11/1.
 */
public abstract class MVPBaseFragment<T extends MVPBasePresenter> extends BaseFragment implements BaseContract.View {
    protected MVPBasePresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
        super.onDestroy();
    }


    public abstract T createPresenter();
}
