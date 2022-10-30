package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.CategoriesResponse;

import java.util.List;

public interface HomeContract {
    interface View extends BaseView {
        void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList);
    }

    interface Presenter extends BasePresenter {
        void getCategories();
        void onResultCategoriesResponse(List<CategoriesResponse> categoriesResponse);
    }
}
