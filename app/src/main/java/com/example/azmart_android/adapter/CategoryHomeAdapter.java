package com.example.azmart_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.databinding.CategoryHomeItemBinding;
import com.example.azmart_android.view.home.HomeFragment;

import java.util.List;

public class CategoryHomeAdapter extends RecyclerView.Adapter<CategoryHomeAdapter.CategoryHomeViewHolder> {
    List<CategoriesResponse> categoriesResponseList;
    HomeFragment homeFragment;
    private List<Integer> colorList;

    public CategoryHomeAdapter(List<CategoriesResponse> categoriesResponseList, HomeFragment homeFragment, List<Integer> colorList) {
        this.categoriesResponseList = categoriesResponseList;
        this.colorList = colorList;
         this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public CategoryHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryHomeViewHolder(CategoryHomeItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHomeViewHolder holder, int position) {
        holder.setData(categoriesResponseList.get(position), colorList.get(position), holder);

    }

    @Override
    public int getItemCount() {
        return categoriesResponseList.size();
    }

    public class CategoryHomeViewHolder extends RecyclerView.ViewHolder {
        private CategoryHomeItemBinding categoryItemBinding;

        public CategoryHomeViewHolder(CategoryHomeItemBinding itemView) {
            super(itemView.getRoot());
            this.categoryItemBinding = itemView;
        }

        void setData(CategoriesResponse categoriesResponse, Integer color, CategoryHomeViewHolder holder) {
            holder.categoryItemBinding.cardView.setCardBackgroundColor(color);
            categoryItemBinding.tvCategory.setText(categoriesResponse.getCategoryName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     // homeFragment.find;
                }
            });

        }
    }
}
