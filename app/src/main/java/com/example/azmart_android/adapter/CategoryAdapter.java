package com.example.azmart_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.databinding.CategoryItemBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    List<CategoriesResponse> categoriesResponseList;
    public CategoryAdapter(List<CategoriesResponse> categoriesResponseList) {
        this.categoriesResponseList=categoriesResponseList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryAdapter.CategoryViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.setData(categoriesResponseList.get(position),holder);

    }

    @Override
    public int getItemCount() {
        return categoriesResponseList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private CategoryItemBinding categoryItemBinding;

        public CategoryViewHolder(CategoryItemBinding itemView) {
            super(itemView.getRoot());
            this.categoryItemBinding = itemView;
        }

        void setData(CategoriesResponse categoriesResponse, CategoryViewHolder holder) {
            categoryItemBinding.categoryTitle.setText(categoriesResponse.getCategoryName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), categoriesResponse.getCategoryName(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
