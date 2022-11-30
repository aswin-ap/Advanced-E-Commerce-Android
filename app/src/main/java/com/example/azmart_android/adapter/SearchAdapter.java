package com.example.azmart_android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.SearchItemBinding;
import com.example.azmart_android.view.search.SearchFragment;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    SearchResponse searchResponseList;
    SearchFragment searchFragment;
    CircularProgressDrawable circularProgressDrawable;
    RequestOptions requestOptions;

    public SearchAdapter(SearchResponse searchResponseList, SearchFragment searchFragment) {
        this.searchResponseList = searchResponseList;
        this.searchFragment = searchFragment;

        circularProgressDrawable = new CircularProgressDrawable(searchFragment.getContext());
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        requestOptions = new RequestOptions();
        requestOptions.placeholder(circularProgressDrawable);
        requestOptions.error(R.drawable.ic_image_error);
        requestOptions.skipMemoryCache(true);
        requestOptions.fitCenter();

    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(SearchItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.setData(searchResponseList.getDocs().get(position), holder);
    }

    @Override
    public int getItemCount() {
        return searchResponseList != null ? searchResponseList.getDocs().size() : 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private SearchItemBinding searchItemBinding;

        public SearchViewHolder(SearchItemBinding itemView) {
            super(itemView.getRoot());
            this.searchItemBinding = itemView;
        }

        void setData(SearchResponse.Docs docs, SearchViewHolder holder) {
            try {
                searchItemBinding.tvTitle.setText(docs.getProductTitle());
                searchItemBinding.ratingItem.setRating((float) docs.getMetadata().getEvaluation().getStarRating());
                Glide.with(searchItemBinding.getRoot().getContext())
                        .load(docs.getMetadata().getImage().getImgUrl())
                        //.load(docs.getProductMainImageUrl())
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(searchItemBinding.ivProduct);
                searchItemBinding.tvPrice.setText(docs.getMetadata().getPrices().getSalePrice().getFormattedPrice());

            } catch (Exception e) {
                Log.e("error :", e.toString());
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    searchFragment.navigateToProducts(docs.getProductId(), docs.getProductTitle());

                }
            });

        }
    }

}


