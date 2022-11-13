package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.BestProductsResponse;
import com.example.azmart_android.data.model.CategoriesResponse;

import java.util.List;
import java.util.Map;

public interface HomeContract {
    interface View extends BaseView {
        void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList);
        void showBestProductsResponse(List<BestProductsResponse> bestProductsResponses);
        void showSearchCategoriesList(List<CategoriesResponse> categoriesResponse);
    }

    interface Presenter extends BasePresenter {
        void getSearchCategories();
        void onSearchCategoryResultResponse(List<CategoriesResponse> categoriesResponse);
        void getHomeDetails();
        void getCategoriesResponse(List<CategoriesResponse> categoriesResponse);
        void getBestProductsResponse(List<BestProductsResponse> bestProductsResponse);


    }
}
