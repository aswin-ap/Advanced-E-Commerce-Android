package com.example.azmart_android.view.search;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.azmart_android.adapter.SearchAdapter;
import com.example.azmart_android.contracts.SearchContract;
import com.example.azmart_android.databinding.FragmentSearchBinding;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.presenter.SearchPresenter;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.Products.ProductsFragmentDirections;


public class SearchFragment extends BaseFragment implements SearchContract.View {
    private String searchKeyword;
    private FragmentSearchBinding binding;
    private SearchPresenter searchPresenter;
    private SearchAdapter searchAdapter;
    private SearchResponse searchResponseList;
    private boolean isFirstTime = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchPresenter = new SearchPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        searchKeyword = SearchFragmentArgs.fromBundle(getArguments()).getSearch();
        Log.d("Search", "onViewCreated: " + searchKeyword);
        binding.ivBack.setOnClickListener(view -> {
            requireActivity().onBackPressed();
        });

        searchPresenter.getItemsBySearch(searchKeyword);
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
        showToast(requireContext(), string);
    }

    @Override
    public void showSearchResponse(SearchResponse searchResponse) {
        binding.progressCircularLayout.getRoot().setVisibility(View.GONE);
        binding.rvSearch.setVisibility(View.VISIBLE);
        binding.tvResults.setText("Results "+searchResponse.getTotalRecordCount());
        searchResponseList = searchResponse;
        if (isFirstTime) {
            searchAdapter = new SearchAdapter(searchResponseList, this);
            binding.rvSearch.setHasFixedSize(true);
            binding.rvSearch.setAdapter(searchAdapter);
        }
        //searchAdapter.updateSearchListItems(searchResponseList.getDocs());
    }

    public void navigateToProducts(String productId, String productName) {
        Navigation.findNavController(requireView()).navigate(SearchFragmentDirections.actionSearchFragmentToProductFragment(productId,productName));

    }
}