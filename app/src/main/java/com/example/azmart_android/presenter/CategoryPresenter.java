package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.CategoryContract;
import com.example.azmart_android.contracts.SearchContract;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;

import java.util.List;

public class CategoryPresenter implements CategoryContract.Presenter {

    CategoryContract.View mView;
    ApiDataManager mApiDataManager;

    public CategoryPresenter(CategoryContract.View mView) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getCategories() {
        mView.showLoading();
        mApiDataManager.getCategoryList(this);
    }

    @Override
    public void onCategoryResultResponse(List<CategoriesResponse> categoriesResponse) {
        mView.showCategoriesResponse(categoriesResponse);
    }
}
