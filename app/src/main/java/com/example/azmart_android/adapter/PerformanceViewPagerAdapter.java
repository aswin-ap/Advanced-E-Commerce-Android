package com.example.azmart_android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.azmart_android.data.model.PerformanceBannerModel;
import com.example.azmart_android.databinding.PerformanceBannerItemBinding;
import com.example.azmart_android.databinding.PerformanceItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class PerformanceViewPagerAdapter extends SliderViewAdapter<PerformanceViewPagerAdapter.PerformanceViewHolder> {
    List<PerformanceBannerModel> performanceModels;

    public PerformanceViewPagerAdapter(List<PerformanceBannerModel> imageList) {
        this.performanceModels = imageList;
    }

    @NonNull
    @Override
    public PerformanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new PerformanceViewHolder(PerformanceBannerItemBinding.inflate(LayoutInflater.from(parent.getContext()),
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
        private PerformanceBannerItemBinding performanceItemBinding;

        public PerformanceViewHolder(PerformanceBannerItemBinding itemView) {
            super(itemView.getRoot());
            this.performanceItemBinding = itemView;
        }

        void setData(PerformanceBannerModel model) {
            performanceItemBinding.ivProduct.setImageResource(model.getImageId());
            performanceItemBinding.tvTitle.setText(model.getDescription());
        }
    }
}
