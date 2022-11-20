package com.example.azmart_android.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.SearchItemBinding;
import com.example.azmart_android.view.product.ProductsFragment;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.SearchViewHolder> {
    SearchResponse searchResponseList;
    ProductsFragment productsFragment;

    public ProductsAdapter(SearchResponse searchResponseList, ProductsFragment productsFragment) {
        this.searchResponseList = searchResponseList;
        this.productsFragment=productsFragment;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(SearchItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.setData(searchResponseList.getDocs().get(position),holder);
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
                        .load(docs.getProductMainImageUrl())
                        .placeholder(R.drawable.ic_image_placeholder)
                        .error(R.drawable.ic_image_error)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(searchItemBinding.ivProduct);
                searchItemBinding.tvPrice.setText(docs.getMetadata().getPrices().getSalePrice().getFormattedPrice());

            }catch (Exception e){
                Log.e("error :",e.toString());
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    productsFragment.navigateToProduct(docs.getProductId(),docs.getProductTitle());
                }
            });

        }
    }

    public void updateSearchListItems(List<SearchResponse.Docs> searchResponseList) {
        final SearchDiffCallback diffCallback = new SearchDiffCallback(this.searchResponseList.getDocs(), searchResponseList);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.searchResponseList.getDocs().clear();
        this.searchResponseList.getDocs().addAll(searchResponseList);
        diffResult.dispatchUpdatesTo(this);
    }
}


