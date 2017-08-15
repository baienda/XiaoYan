package com.baienda.xiaoyan.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.FriendRequestAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.NewFriendContract;
import com.baienda.xiaoyan.mvp.presenter.NewFriendPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NewFriendActivity extends MVPBaseActivity<NewFriendPresenter> implements NewFriendContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @BindView(R.id.rv_friend_request_list)
    RecyclerView rv_friend_request_list;

    private FriendRequestAdapter new_friend_adapter;
    private List new_friend_data;

    @Override
    public int setLayout() {
        return R.layout.activity_new_friend;
    }

    @Override
    public void initEvent() {
        iv_left.setOnClickListener(this);
    }

    @Override
    public void init() {
        tv_title.setText(getString(R.string.new_friend));
        new_friend_data = new ArrayList();
        new_friend_adapter = new FriendRequestAdapter(this, R.layout.item_friend_request, new_friend_data);
        rv_friend_request_list.setAdapter(new_friend_adapter);
        rv_friend_request_list.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.start();
    }

    @Override
    public NewFriendPresenter createPresenter() {
        return new NewFriendPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
        }
    }

    @Override
    public void setFriendRequestData(List data) {
        new_friend_data.clear();
        new_friend_data.addAll(data);
        new_friend_adapter.notifyDataSetChanged();
    }
}
