package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.ChooseCityContract;
import com.baienda.xiaoyan.mvp.model.ChooseCityModel;
import com.baienda.xiaoyan.mvp.view.activity.ChooseCityActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serenade on 2017/8/14.
 */

public class ChooseCityPresenter extends MVPBasePresenter<ChooseCityActivity,ChooseCityModel> implements ChooseCityContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add("北京市 " + i);
        }
        mView.setCityData(data);
    }
}
