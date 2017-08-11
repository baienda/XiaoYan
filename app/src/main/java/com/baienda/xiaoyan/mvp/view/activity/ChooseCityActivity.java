package com.baienda.xiaoyan.mvp.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baienda.xiaoyan.R;
import com.baienda.xiaoyan.adapter.ChooseCityAdapter;
import com.baienda.xiaoyan.base.BaseActivity;
import com.baienda.xiaoyan.recyclerview.OnItemClickListener;
import com.baienda.xiaoyan.recyclerview.RecyclerViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChooseCityActivity extends BaseActivity implements OnItemClickListener {
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
        location_data = new ArrayList();
        for (int i = 0; i < 40; i++) {
            location_data.add("北京市 "+i);
        }
        choose_city_adapter = new ChooseCityAdapter(this, location_data);
        rv_city_list.setAdapter(choose_city_adapter);
        rv_city_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_city_list.addItemDecoration(new RecyclerViewDivider(false));
        choose_city_adapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(View view, int position) {
        String city = location_data.get(position);
        Intent intent = new Intent();
        intent.putExtra("city",city);
        setResult(RESULT_OK,intent);
        finish();
    }
}
