package com.example.azmart_android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.databinding.DealsLayoutBinding;

import java.util.List;

public class DealsViewPagerAdapter extends RecyclerView.Adapter<DealsViewPagerAdapter.DealsViewHolder> {
    List<String> imageList;

    public DealsViewPagerAdapter(List<String> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DealsViewHolder(DealsLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DealsViewHolder holder, int position) {
        holder.setData(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class DealsViewHolder extends RecyclerView.ViewHolder {
        private DealsLayoutBinding dealsLayoutBinding;

        public DealsViewHolder(DealsLayoutBinding itemView) {
            super(itemView.getRoot());
            this.dealsLayoutBinding = itemView;
        }

        void setData(String imageUrl) {
            Glide.with(dealsLayoutBinding.getRoot().getContext())
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(dealsLayoutBinding.ivImage);
        }
    }
}
