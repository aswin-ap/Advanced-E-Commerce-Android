package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.HomeContract;
import com.example.azmart_android.data.model.BestProductsResponse;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.Presenter {
    public ArrayList<String> dealsList = new ArrayList();
    HomeContract.View mView;
    ApiDataManager mApiDataManager;

    public HomePresenter(HomeContract.View mView) {
        mApiDataManager = new ApiDataManager();
        this.mView = mView;
        dealsList.add("https://img.freepik.com/premium-vector/special-offer-sale-discount-banner_180786-46.jpg?w=2000");
        dealsList.add("https://img.freepik.com/free-vector/super-sale-horizontal-banner_52683-59532.jpg?w=2000");
        dealsList.add("https://img.freepik.com/free-vector/sale-banner-with-product-description_1361-1333.jpg?w=2000");
        dealsList.add("https://s.tmimgcdn.com/scr/1200x750/268600/product-promotion-social-media-banners-00273_268696-original.jpg");
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);
    }


    @Override
    public void getHomeDetails() {
        mView.showLoading();
        mApiDataManager.getHomeDetails(this);
    }

    @Override
    public void getSearchCategories(){
        mApiDataManager.getSearchCategoriesList(this);
    }


    @Override
    public void getCategoriesResponse(List<CategoriesResponse> categoriesResponse) {
        mView.showCategoriesResponse(categoriesResponse);
    }

    @Override
    public void getBestProductsResponse(List<BestProductsResponse> bestProductsResponse) {
        mView.hideLoading();
        mView.showBestProductsResponse(bestProductsResponse);
    }

    @Override
    public void onSearchCategoryResultResponse(List<CategoriesResponse> categoriesResponse) {
        mView.showSearchCategoriesList(categoriesResponse);
    }
}
