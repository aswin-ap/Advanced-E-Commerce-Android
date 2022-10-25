package com.example.azmart_android.view.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.azmart_android.contracts.SearchContract;
import com.example.azmart_android.databinding.FragmentSearchBinding;
import com.example.azmart_android.model.SearchResponse;
import com.example.azmart_android.presenter.SearchPresenter;
import com.example.azmart_android.view.BaseFragment;


public class SearchFragment extends BaseFragment implements SearchContract.View {

    private static final String SEARCH_KEYWORD = "searchText";
    private String searchKeyword;
    private FragmentSearchBinding binding;
    private SearchPresenter searchPresenter;

    public static SearchFragment newInstance(String text) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(SEARCH_KEYWORD, fragment.searchKeyword);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            searchKeyword = getArguments().getString(SEARCH_KEYWORD);
        }
        searchPresenter = new SearchPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {

    }

    @Override
    public void showLoading() {
        showLoadingDialog(requireContext());
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }

    @Override
    public void showApiErrorWarning(String string) {
        showToast(requireContext(), string);
    }

    @Override
    public void showSearchResponse(SearchResponse searchResponse) {

    }
}