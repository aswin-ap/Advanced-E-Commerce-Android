package com.example.azmart_android.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.WishListModel;
import com.example.azmart_android.databinding.SearchItemBinding;
import com.example.azmart_android.utils.OnItemClickListener;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.SearchViewHolder> {
    List<WishListModel> wishListModelList;
    OnItemClickListener clickListener;

    public WishlistAdapter(List<WishListModel> wishListModelList, OnItemClickListener clickListener) {
        this.wishListModelList = wishListModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(SearchItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.setData(wishListModelList.get(position));

        holder.itemView.setOnClickListener(v -> {
            clickListener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return wishListModelList != null ? wishListModelList.size() : 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private SearchItemBinding searchItemBinding;

        public SearchViewHolder(SearchItemBinding itemView) {
            super(itemView.getRoot());
            this.searchItemBinding = itemView;
        }

        void setData(WishListModel wishListModel) {
            try {
                searchItemBinding.tvTitle.setText(wishListModel.getTitle());
                searchItemBinding.ratingItem.setRating(Float.parseFloat(wishListModel.getRating()));
                Glide.with(searchItemBinding.getRoot().getContext())
                        .load(wishListModel.getImageUrl())
                        .placeholder(R.drawable.ic_image_placeholder)
                        .error(R.drawable.ic_image_error)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(searchItemBinding.ivProduct);
                searchItemBinding.tvPrice.setText(wishListModel.getPrice());

            } catch (Exception e) {
                Log.e("error :", e.toString());
            }

        }
    }
}


