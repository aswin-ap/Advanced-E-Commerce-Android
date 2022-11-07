package com.example.azmart_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.BestProductsResponse;
import com.example.azmart_android.databinding.BestProductItemBinding;
import com.example.azmart_android.view.home.HomeFragment;

import java.util.List;

public class BestProductHomeAdapter extends RecyclerView.Adapter<BestProductHomeAdapter.BestProductHomeViewHolder> {
    List<BestProductsResponse> bestProductsResponses;
    HomeFragment homeFragment;

    public BestProductHomeAdapter(List<BestProductsResponse> bestProductsResponses, HomeFragment homeFragment) {
        this.bestProductsResponses = bestProductsResponses;
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public BestProductHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BestProductHomeViewHolder(BestProductItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BestProductHomeViewHolder holder, int position) {
        holder.setData(bestProductsResponses.get(position), holder);

    }

    @Override
    public int getItemCount() {
        return bestProductsResponses.size();
    }

    public class BestProductHomeViewHolder extends RecyclerView.ViewHolder {
        private BestProductItemBinding bestProductItemBinding;

        public BestProductHomeViewHolder(BestProductItemBinding itemView) {
            super(itemView.getRoot());
            this.bestProductItemBinding = itemView;
        }

        void setData(BestProductsResponse categoriesResponse, BestProductHomeViewHolder holder) {
            bestProductItemBinding.tvTitle.setText(categoriesResponse.getProductTitle());
            Glide.with(bestProductItemBinding.getRoot().getContext())
                    .load(categoriesResponse.getProductSmallImageUrls().getString().get(0))
                    .placeholder(R.drawable.ic_image_placeholder)
                    .error(R.drawable.ic_image_error)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(bestProductItemBinding.ivProduct);
            bestProductItemBinding.tvPrice.setText("USD " + String.valueOf(categoriesResponse.getAppSalePrice()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // homeFragment.find;
                    homeFragment.navigateToProduct(categoriesResponse.getProductId(),categoriesResponse.getProductTitle());
                }
            });

        }
    }
}
