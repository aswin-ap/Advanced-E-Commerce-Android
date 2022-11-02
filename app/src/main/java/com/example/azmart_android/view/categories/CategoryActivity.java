package com.example.azmart_android.view.categories;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.azmart_android.adapter.CategoryAdapter;
import com.example.azmart_android.contracts.CategoryContract;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.databinding.ActivityCategoryBinding;
import com.example.azmart_android.presenter.CategoryPresenter;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View {

    private ActivityCategoryBinding binding;
    private CategoryPresenter categoryPresenter;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        categoryPresenter=new CategoryPresenter(this);
        initView();
    }

    private void initView() {
        categoryPresenter.getCategories();
    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
        binding.rvCategory.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvCategory.setVisibility(View.GONE);
    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvCategory.setVisibility(View.GONE);
        showToast(this, string);
    }

    @Override
    public void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList) {

        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvCategory.setVisibility(View.VISIBLE);
        categoryAdapter=new CategoryAdapter(categoriesResponseList);
        binding.rvCategory.setHasFixedSize(true);
        binding.rvCategory.setAdapter(categoryAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.rvCategory.getContext(),
                DividerItemDecoration.VERTICAL);
        binding.rvCategory.addItemDecoration(dividerItemDecoration);

    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}