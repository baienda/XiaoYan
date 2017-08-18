package com.baienda.xiaoyan.base.mvpbase;


import com.baienda.xiaoyan.retrofit.NetManager;

/**
 * Created by hjn on 2016/11/3.
 */
public abstract class MVPBasePresenter<T extends BaseContract.View, M extends MVPBaseModel> {
    protected T mView;
    protected M mModel;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void detach() {
        if (mView != null) {
            mView = null;
            //取消该页面所有网络请求
            NetManager.getInstance().cancelRequests(getClass().getName());
        }
    }

    public boolean isAttach() {
        return mView != null;
    }

}