package com.example.azmart_android.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.OrderHistoryModel;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.OrderItemBinding;
import com.example.azmart_android.databinding.SearchItemBinding;
import com.example.azmart_android.view.Order.OrderHistoryFragment;
import com.example.azmart_android.view.product.ProductsFragment;

import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.SearchViewHolder> {
    List<OrderHistoryModel> orderHistoryModels;
    OrderHistoryFragment orderHistoryFragment;
    CircularProgressDrawable circularProgressDrawable;
    RequestOptions requestOptions;

    public OrderHistoryAdapter(OrderHistoryFragment orderHistoryFragment, List<OrderHistoryModel> orderHistoryModels) {
        this.orderHistoryModels = orderHistoryModels;
        this.orderHistoryFragment = orderHistoryFragment;

        circularProgressDrawable = new CircularProgressDrawable(orderHistoryFragment.getContext());
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
        return new SearchViewHolder(OrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.setData(orderHistoryModels.get(position), holder);
    }

    @Override
    public int getItemCount() {
        return orderHistoryModels != null ? orderHistoryModels.size() : 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        private OrderItemBinding orderItemBinding;

        public SearchViewHolder(OrderItemBinding itemView) {
            super(itemView.getRoot());
            this.orderItemBinding = itemView;
        }

        void setData(OrderHistoryModel orderHistoryModels, SearchViewHolder holder) {
            try {
                orderItemBinding.tvTitle.setText(orderHistoryModels.getProductTitle());
//                searchItemBinding.ratingItem.setRating((float) docs.getMetadata().getEvaluation().getStarRating());
                Glide.with(orderItemBinding.getRoot().getContext())
                        .load(orderHistoryModels.getProductImage())
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(orderItemBinding.ivProduct);
//                searchItemBinding.tvPrice.setText(docs.getMetadata().getPrices().getSalePrice().getFormattedPrice());

            } catch (Exception e) {
                Log.e("error :", e.toString());
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    orderHistoryFragment.navigateToProduct(docs.getProductId(), docs.getProductTitle());
                }
            });

        }
    }
}


