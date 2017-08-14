package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.CategoryInfoContract;
import com.baienda.xiaoyan.mvp.view.activity.CategoryInfoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serenade on 2017/8/14.
 */

public class CategoryInfoPresenter extends MVPBasePresenter<CategoryInfoActivity> implements CategoryInfoContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add(i);
        }
        mView.setCategoryInfoData(data);
    }
}
