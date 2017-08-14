package com.baienda.xiaoyan.mvp.view.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.CategoryInfoContract;
import com.baienda.xiaoyan.mvp.presenter.CategoryInfoPresenter;
import com.baienda.xiaoyan.recyclerview.CommonAdapter;
import com.baienda.xiaoyan.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CategoryInfoActivity extends MVPBaseActivity<CategoryInfoPresenter> implements CategoryInfoContract.View {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.iv_left)
    ImageView iv_left;
    @BindView(R.id.iv_right)
    ImageView iv_right;

    @BindView(R.id.rv_info_list)
    RecyclerView rv_info_list;

    private CommonAdapter category_info_adapter;
    private List category_info_data;

    @Override
    public int setLayout() {
        return R.layout.activity_category_info;
    }

    @Override
    public void initEvent() {
        iv_left.setOnClickListener(this);
    }

    @Override
    public void init() {
        iv_right.setVisibility(View.GONE);
        String title = getIntent().getExtras().getString("title");
        tv_title.setText(title);
        category_info_data = new ArrayList();
        category_info_adapter = new CommonAdapter(this, R.layout.item_category_info, category_info_data) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {

            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView) {
                super.onViewHolderCreated(holder, itemView);
                final ImageView image = holder.getView(R.id.iv_image);
                image.setColorFilter(getResources().getColor(R.color.transparent_black));
                image.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                image.setColorFilter(Color.TRANSPARENT);
                                return true;
                            case MotionEvent.ACTION_UP:
                                Log.e("======", "点击了");
                                image.setColorFilter(getResources().getColor(R.color.transparent_black));
                                return false;
                            case MotionEvent.ACTION_CANCEL:
                                image.setColorFilter(getResources().getColor(R.color.transparent_black));
                                return false;
                        }
                        return false;
                    }
                });
            }
        };
        rv_info_list.setAdapter(category_info_adapter);
        rv_info_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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
