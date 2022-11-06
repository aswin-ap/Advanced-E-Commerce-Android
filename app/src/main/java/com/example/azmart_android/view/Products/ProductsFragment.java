package com.example.azmart_android.view.Products;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.ProductsAdapter;
import com.example.azmart_android.adapter.SearchAdapter;
import com.example.azmart_android.contracts.ProductsContract;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.databinding.FragmentProductsBinding;
import com.example.azmart_android.presenter.ProductsPresenter;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.view.categories.CategoryFragmentDirections;


public class ProductsFragment extends Fragment implements ProductsContract.View {

    private FragmentProductsBinding binding;
    private ProductsPresenter productsPresenter;
    private ProductsAdapter productsAdapter;
    private SearchResponse searchResponseList;
    private String categoryName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsPresenter=new ProductsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.srfProduct.setColorSchemeColors(getResources().getColor(R.color.green_700));
        binding.srfProduct.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                binding.srfProduct.setRefreshing(false);
            }
        });
        initView();
    }

    private void initView() {
        categoryName=ProductsFragmentArgs.fromBundle(getArguments()).getCategoryName();
        binding.tvResults.setText(categoryName);
        String categoryId = ProductsFragmentArgs.fromBundle(getArguments()).getCaregoryId();
        if (NetworkManager.isNetworkAvailable(requireContext())) {
            binding.tvNetworkWorning.setVisibility(View.GONE);
            productsPresenter.getProducts(categoryId);
        } else{
            binding.tvNetworkWorning.setVisibility(View.VISIBLE);
            binding.rvSearch.setVisibility(View.GONE);
        }

        binding.ivBack.setOnClickListener(view -> {
            requireActivity().onBackPressed();
        });
    }

    @Override
    public void showLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.VISIBLE);
        binding.rvSearch.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.GONE);
    }

    @Override
    public void showApiErrorWarning(String string) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.GONE);
        showToast(requireActivity(), string);
    }

    @Override
    public void showProductsResponse(SearchResponse searchResponse) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.VISIBLE);
        if (searchResponse.getTotalRecordCount()==0){
            binding.rvSearch.setVisibility(View.GONE);
            binding.tvNoData.setVisibility(View.VISIBLE);
        }else {
            searchResponseList = searchResponse;
            productsAdapter = new ProductsAdapter(searchResponseList, this);
            binding.rvSearch.setHasFixedSize(true);
            binding.rvSearch.setAdapter(productsAdapter);
            binding.tvNoData.setVisibility(View.GONE);
            productsAdapter.notifyDataSetChanged();
        }
    }

    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void navigateToProduct(String productId, String productName) {
        Navigation.findNavController(requireView()).navigate(ProductsFragmentDirections.actionProductsFragmentToProductFragment(productId,productName));

    }

}