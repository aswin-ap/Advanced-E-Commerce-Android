package com.example.azmart_android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.azmart_android.data.model.PerformanceModel;
import com.example.azmart_android.databinding.PerformanceItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class PerformanceViewPagerAdapter extends SliderViewAdapter<PerformanceViewPagerAdapter.PerformanceViewHolder> {
    List<PerformanceModel> performanceModels;

    public PerformanceViewPagerAdapter(List<PerformanceModel> imageList) {
        this.performanceModels = imageList;
    }

    @NonNull
    @Override
    public PerformanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new PerformanceViewHolder(PerformanceItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PerformanceViewHolder holder, int position) {
        holder.setData(performanceModels.get(position));
    }

    @Override
    public int getCount() {
        return performanceModels.size();
    }

    public class PerformanceViewHolder extends ViewHolder {
        private PerformanceItemBinding performanceItemBinding;

        public PerformanceViewHolder(PerformanceItemBinding itemView) {
            super(itemView.getRoot());
            this.performanceItemBinding = itemView;
        }

        void setData(PerformanceModel model) {
            performanceItemBinding.ivProduct.setImageResource(model.getImageId());
            performanceItemBinding.tvTitle.setText(model.getDescription());
        }
    }
}
