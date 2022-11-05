package com.example.azmart_android.view.categories;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.azmart_android.adapter.CategoryAdapter;
import com.example.azmart_android.contracts.CategoryContract;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.databinding.FragmentCategoryBinding;
import com.example.azmart_android.presenter.CategoryPresenter;

import java.util.List;

public class CategoryFragment extends Fragment implements CategoryContract.View {

    private FragmentCategoryBinding binding;
    private CategoryPresenter categoryPresenter;
    private CategoryAdapter categoryAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryPresenter=new CategoryPresenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        showToast(requireActivity(), string);
    }

    @Override
    public void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList) {

        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvCategory.setVisibility(View.VISIBLE);
        categoryAdapter=new CategoryAdapter(categoriesResponseList,this);
        binding.rvCategory.setHasFixedSize(true);
        binding.rvCategory.setAdapter(categoryAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.rvCategory.getContext(),
                DividerItemDecoration.VERTICAL);
        binding.rvCategory.addItemDecoration(dividerItemDecoration);

    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void navigateToProducts(Integer apiCategoryId, String categoryName) {
        Navigation.findNavController(requireView()).navigate(CategoryFragmentDirections.actionCategoryFragmentToProductsFragment(apiCategoryId,categoryName));

    }
}