package com.baienda.xiaoyan.mvp.presenter;

import com.baienda.xiaoyan.base.mvpbase.MVPBasePresenter;
import com.baienda.xiaoyan.mvp.contract.VideoContract;
import com.baienda.xiaoyan.mvp.view.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XY02 on 2017/8/10.
 */

public class VideoPresenter extends MVPBasePresenter<VideoFragment> implements VideoContract.Presenter {
    @Override
    public void start() {
        List data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            data.add(i);
        }
        mView.setVideoData(data);
    }
}
