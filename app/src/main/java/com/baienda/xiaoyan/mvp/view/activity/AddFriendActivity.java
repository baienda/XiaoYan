package com.baienda.xiaoyan.mvp.view.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.UserListAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.AddFriendContract;
import com.baienda.xiaoyan.mvp.presenter.AddFriendPresenter;
import com.baienda.xiaoyan.recyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddFriendActivity extends MVPBaseActivity<AddFriendPresenter> implements AddFriendContract.View, View.OnTouchListener {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @BindView(R.id.et_input)
    EditText et_input;

    @BindView(R.id.rv_user_list)
    RecyclerView rv_user_list;

    private UserListAdapter user_list_adapter;
    private List user_list_data;

    @Override
    public int setLayout() {
        return R.layout.activity_add_friend;
    }

    @Override
    public void initEvent() {
        iv_left.setOnClickListener(this);
        et_input.setOnTouchListener(this);
    }

    @Override
    public void init() {
        tv_title.setText(getString(R.string.search_friend));

        user_list_data = new ArrayList();
        user_list_adapter = new UserListAdapter(this, R.layout.item_user_list, user_list_data);
        rv_user_list.setAdapter(user_list_adapter);
        rv_user_list.setLayoutManager(new LinearLayoutManager(this));
        rv_user_list.addItemDecoration(new DividerDecoration(false));

        mPresenter.start();
    }

    @Override
    public AddFriendPresenter createPresenter() {
        return new AddFriendPresenter();
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
    public boolean onTouch(View v, MotionEvent event) {
        //获得右侧图片
        Drawable drawable = et_input.getCompoundDrawables()[2];
        //如果不是按下事件，不再处理
        if (event.getAction() != MotionEvent.ACTION_UP)
            return false;
        if (event.getX() > et_input.getWidth() - et_input.getPaddingRight() - drawable.getIntrinsicWidth()) {
            String search = et_input.getText().toString();
            Log.e("======", "==" + search);
        }
        return false;
    }

    @Override
    public void setUserListData(List data) {
        user_list_data.clear();
        user_list_data.addAll(data);
        user_list_adapter.notifyDataSetChanged();
    }
}
