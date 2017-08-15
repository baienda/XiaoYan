package com.baienda.xiaoyan.mvp.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.ChooseCityAdapter;
import com.baienda.xiaoyan.base.mvpbase.MVPBaseActivity;
import com.baienda.xiaoyan.mvp.contract.ChooseCityContract;
import com.baienda.xiaoyan.mvp.presenter.ChooseCityPresenter;
import com.baienda.xiaoyan.recyclerview.MultiItemTypeAdapter;
import com.baienda.xiaoyan.recyclerview.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChooseCityActivity extends MVPBaseActivity<ChooseCityPresenter> implements ChooseCityContract.View, MultiItemTypeAdapter.OnItemClickListener {
    @BindView(R.id.rv_city_list)
    RecyclerView rv_city_list;

    private ChooseCityAdapter choose_city_adapter;
    private List<String> location_data;

    @Override
    public int setLayout() {
        return R.layout.activity_choose_city;
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void init() {
        location_data = new ArrayList<String>();
        choose_city_adapter = new ChooseCityAdapter(this, R.layout.item_choose_city, location_data);
        rv_city_list.setAdapter(choose_city_adapter);
        rv_city_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_city_list.addItemDecoration(new RecyclerViewDivider(false));
        choose_city_adapter.setOnItemClickListener(this);

        mPresenter.start();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public ChooseCityPresenter createPresenter() {
        return new ChooseCityPresenter();
    }

    @Override
    public void setCityData(List<String> data) {
        location_data.clear();
        location_data.addAll(data);
        choose_city_adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position, RecyclerView.Adapter adapter) {
        String city = location_data.get(position);
        Intent intent = new Intent();
        intent.putExtra("city", city);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position, RecyclerView.Adapter adapter) {
        return false;
    }
}
