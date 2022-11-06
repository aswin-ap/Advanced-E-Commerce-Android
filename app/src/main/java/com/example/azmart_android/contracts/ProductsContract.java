package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.SearchResponse;

public interface ProductsContract {

    interface View extends BaseView {
        void showProductsResponse(SearchResponse searchResponse);
    }

    interface Presenter extends BasePresenter {
        void getProducts(String categoryId);

        void onProductsResultResponse(SearchResponse searchResponse);
    }

}
