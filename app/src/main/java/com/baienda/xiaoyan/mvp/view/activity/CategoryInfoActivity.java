package com.baienda.xiaoyan.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.CategoryInfoAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.CategoryInfoContract;
import com.baienda.xiaoyan.mvp.presenter.CategoryInfoPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryInfoActivity extends MVPBaseActivity<CategoryInfoPresenter> implements CategoryInfoContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;

    @BindView(R.id.rv_info_list)
    RecyclerView rv_info_list;

    private CategoryInfoAdapter category_info_adapter;
    private List category_info_data;

    @Override
    public int setLayout() {
        return R.layout.activity_category_info;
    }

    @Override
    public void onActivityCreated() {
        String title = getIntent().getStringExtra("title");
        tv_title.setText(title);
        iv_left.setOnClickListener(this);


        category_info_data = new ArrayList();
        category_info_adapter = new CategoryInfoAdapter(this, R.layout.item_category_info, category_info_data);
        rv_info_list.setAdapter(category_info_adapter);
        rv_info_list.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.start();
    }

    @Override
    public CategoryInfoPresenter createPresenter() {
        return new CategoryInfoPresenter();
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
    public void setCategoryInfoData(List data) {
        category_info_data.clear();
        category_info_data.addAll(data);
        category_info_adapter.notifyDataSetChanged();
    }
}
