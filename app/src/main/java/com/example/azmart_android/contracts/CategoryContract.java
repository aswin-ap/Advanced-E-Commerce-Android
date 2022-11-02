package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.data.model.SearchResponse;

import java.util.List;

public interface CategoryContract {

    interface View extends BaseView {
        void showCategoriesResponse(List<CategoriesResponse> categoriesResponseList);
    }

    interface Presenter extends BasePresenter {
        void getCategories();

        void onCategoryResultResponse(List<CategoriesResponse> categoriesResponse);
    }

}
