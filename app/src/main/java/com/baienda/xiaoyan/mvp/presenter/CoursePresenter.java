package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.CourseContract;
import com.baienda.xiaoyan.mvp.model.CourseModel;
import com.baienda.xiaoyan.mvp.view.fragment.CourseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XY02 on 2017/8/10.
 */

public class CoursePresenter extends MVPBasePresenter<CourseFragment,CourseModel> implements CourseContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add(i);
        }
        mView.setCourseData(data);
    }
}
