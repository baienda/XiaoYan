package com.baienda.xiaoyan.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.baienda.xiaoyan.base.mvpbase.MVPBaseFragment;
import com.baienda.xiaoyan.retrofit.NetManager;
import com.baienda.xiaoyan.utils.dialog.LoadingDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by admin on 2016/11/1.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected View mRootView;
    protected Activity mActivity;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        if (registerEventBus())
            EventBus.getDefault().register(this);
        mActivity = getActivity();
        onViewCreated();
        return mRootView;
    }

    /**
     * 是否注册EventBus
     *
     * @return true 注册 false 不注册
     */
    public boolean registerEventBus() {
        return false;
    }

    /**
     * 初始化
     */
    public abstract void onViewCreated();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden)
            onPause();
        else
            onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //如果不是MVP模式，则取消记录的网络请求
        if (!(this instanceof MVPBaseFragment)) {
            NetManager.getInstance().cancelRequests(getClass().getName());
        }
    }

    public View getRootView() {
        return mRootView;
    }

    protected abstract int setLayout();


    @Subscribe
    protected void onReceiveEvent(EventCenter event) {
        onEventBusResult(event);
    }

    /**
     * EventBus回传消息重写方法
     *
     * @param event
     */
    public void onEventBusResult(EventCenter event) {

    }

    @Override
    public void onDestroy() {
        mActivity = null;
        mUnbinder.unbind();
        if (registerEventBus())
            EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    protected void showLoadingDialog() {
        LoadingDialog.getInstance().show(mActivity, "加载中...", true);
    }

    protected void dismissDialog() {
        LoadingDialog.getInstance().dismissDialog();
    }

    /**
     * 隐藏输入法
     *
     * @param view
     */
    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 显示输入法
     *
     * @param view
     */
    public void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.showSoftInput(view, 0);
    }


    public void startService(Class clz) {
        Intent intent = new Intent(getActivity(), clz);
        getActivity().startService(intent);
    }

    public void startService(Class clz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clz);
        if (bundle != null)
            intent.putExtras(bundle);
        getActivity().startService(intent);
    }

    public void startActivity(Class clz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clz);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivity(Class clz) {
        Intent intent = new Intent(getActivity(), clz);
        startActivity(intent);
    }

    public void startActivityForResult(Class clz, int requestCode) {
        Intent intent = new Intent(getActivity(), clz);
        startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(Class clz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getActivity(), clz);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }
}
