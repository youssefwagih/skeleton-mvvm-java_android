package com.youssef.skeleton.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.youssef.skeleton.BindingViewHolder;
import com.youssef.skeleton.R;
import com.youssef.skeleton.data.remote.models.ResultsItem;

import java.util.List;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private List<ResultsItem> dataList;

    public ArticlesAdapter(List<ResultsItem> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new BindingViewHolder(DataBindingUtil.inflate(layoutInflater,
                R.layout.article_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.getBinding().setVariable(1, dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
