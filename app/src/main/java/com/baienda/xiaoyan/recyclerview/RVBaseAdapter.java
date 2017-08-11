package com.baienda.xiaoyan.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by XY02 on 2017/8/10.
 */

public abstract class RVBaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private OnItemClickListener mOnItemClickListener;
    public Context mContext;
    public List<T> mData;

    public RVBaseAdapter(Context mContext, List<T> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(setLayout(), parent, false);
        view.setOnClickListener(this);
        doInOnCreateViewHolder(view, parent, viewType);
        return ViewHolder.createViewHolder(mContext,view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        doInOnBindViewHolder(holder, position);
    }

    public abstract int setLayout();

    public void doInOnCreateViewHolder(View itemView, ViewGroup parent, int viewType) {

    }

    public abstract void doInOnBindViewHolder(ViewHolder holder, int position);

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
