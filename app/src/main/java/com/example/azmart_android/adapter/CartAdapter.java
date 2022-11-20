package com.example.azmart_android.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.azmart_android.R;
import com.example.azmart_android.data.model.CartModel;
import com.example.azmart_android.databinding.ItemCartProductBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private onCartItemClickListener listener;
    private List<CartModel> list;
    private float itemPrice;


    public CartAdapter(Context context, List<CartModel> list, onCartItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.list = list;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartProductBinding binding = ItemCartProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CartModel model = list.get(position);
        itemPrice = Float.parseFloat(model.getPrice());

        holder.binding.productItem.tvTitle.setText(model.getTitle());
        holder.binding.productItem.ratingItem.setRating(Float.parseFloat(model.getRating()));
        Glide.with(holder.binding.getRoot().getContext())
                .load(model.getImageUrl())
                .placeholder(R.drawable.ic_image_placeholder)
                .error(R.drawable.ic_image_error)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.binding.productItem.ivProduct);
        holder.binding.productItem.tvPrice.setText("USD$ " + model.getPrice());

        for (int i = 1; i < model.getQuantity(); i++) {
            itemPrice = itemPrice + Float.parseFloat(model.getPrice());
        }
        if (model.getQuantity() == 0) {
            //holder.binding.layoutQuantityControl.imageSub.setVisibility(View.GONE);
            holder.binding.layoutQuantityControl.textQuantity.setText("Add");
            holder.binding.layoutQuantityControl.imageSub.setImageResource(R.drawable.ic_minus);
            holder.binding.layoutQuantityControl.imageSub.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            holder.binding.layoutQuantityControl.textQuantity.setText(Integer.toString(model.getQuantity()));
        } else if (model.getQuantity() <= 0) {
            holder.binding.layoutQuantityControl.imageSub.setVisibility(View.GONE);
        } else {
            holder.binding.layoutQuantityControl.imageSub.setImageResource(R.drawable.ic_minus);
            holder.binding.layoutQuantityControl.imageSub.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            holder.binding.layoutQuantityControl.imageSub.setVisibility(View.VISIBLE);
            holder.binding.layoutQuantityControl.textQuantity.setText(Integer.toString(model.getQuantity()));
        }
        holder.binding.layoutQuantityControl.imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onQuantityAdd(position);
            }
        });
        holder.binding.layoutQuantityControl.imageSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.getQuantity() >= 0) {
                    listener.onQuantitySub(position);
                }
            }
        });
        holder.binding.layoutQuantityControl.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public interface onCartItemClickListener {

        void onQuantityAdd(int position);

        void onQuantitySub(int position);

        void onDeleteItem(int position);
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        private ItemCartProductBinding binding;

        public CartViewHolder(@NonNull ItemCartProductBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
