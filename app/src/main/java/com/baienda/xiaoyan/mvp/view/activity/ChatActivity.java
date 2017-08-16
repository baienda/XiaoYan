package com.baienda.xiaoyan.mvp.view.activity;

import android.support.annotation.IdRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.AddressListAdapter;
import com.baienda.xiaoyan.adapter.ChatAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.ChatContract;
import com.baienda.xiaoyan.mvp.presenter.ChatPresenter;
import com.baienda.xiaoyan.recyclerview.decoration.CategoryDecoration;
import com.baienda.xiaoyan.recyclerview.MultiItemTypeAdapter;
import com.baienda.xiaoyan.recyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Serenade on 2017/8/15.
 */

public class ChatActivity extends MVPBaseActivity<ChatPresenter> implements ChatContract.View, RadioGroup.OnCheckedChangeListener, MultiItemTypeAdapter.OnItemClickListener {
    @BindView(R.id.rg_tabs)
    RadioGroup rg_tabs;

    @BindView(R.id.rb_chat)
    RadioButton rb_chat;
    @BindView(R.id.rb_address_list)
    RadioButton rb_address_list;

    @BindView(R.id.rv_friends)
    RecyclerView rv_friends;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    private ChatAdapter chat_adapter;
    private AddressListAdapter address_list_adapter;
    private List chat_data;
    private List address_list_data;
    private boolean is_left_tab_choosed = true;
    private CategoryDecoration category_decoration;

    @Override
    public ChatPresenter createPresenter() {
        return new ChatPresenter();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_chat;
    }

    @Override
    public void initEvent() {
        iv_left.setOnClickListener(this);
        rg_tabs.setOnCheckedChangeListener(this);
    }

    @Override
    public void init() {
        chat_data = new ArrayList();
        address_list_data = new ArrayList();

        chat_adapter = new ChatAdapter(this, R.layout.item_chat, chat_data);
        chat_adapter.setOnItemClickListener(this);

        address_list_adapter = new AddressListAdapter(this, R.layout.item_address_list, address_list_data);
        address_list_adapter.setOnItemClickListener(this);

        rv_friends.setAdapter(chat_adapter);
        rv_friends.setLayoutManager(new LinearLayoutManager(this));
        rv_friends.addItemDecoration(new DividerDecoration(false));

        category_decoration = new CategoryDecoration(this);

        mPresenter.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                finish();
                break;
        }
    }

    //添加功能按钮
    private void addFunctionItem() {
        address_list_data.add(1);
        address_list_data.add(1);
        address_list_data.add(1);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_chat:
                is_left_tab_choosed = true;
                rv_friends.setAdapter(chat_adapter);
                rv_friends.removeItemDecoration(category_decoration);
                break;
            case R.id.rb_address_list:
                is_left_tab_choosed = false;
                rv_friends.setAdapter(address_list_adapter);
                rv_friends.addItemDecoration(category_decoration);
                break;
        }
    }

    @Override
    public void setChatData(List data) {
        chat_data.clear();
        chat_data.addAll(data);
        chat_adapter.notifyDataSetChanged();
    }

    @Override
    public void setAddressListData(List data) {
        address_list_data.clear();
        addFunctionItem();
        address_list_data.addAll(data);
        address_list_adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position, RecyclerView.Adapter adapter) {
        if (adapter == chat_adapter) {

        } else if (adapter == address_list_adapter) {
            switch (position) {
                case 0:
                    startActivity(NewFriendActivity.class);
                    break;
                case 1:
                    startActivity(AddFriendActivity.class);
                    break;
                case 2:
                    startActivity(GroupActivity.class);
                    break;
                default:
            }
        }
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position, RecyclerView.Adapter adapter) {
        return false;
    }
}
