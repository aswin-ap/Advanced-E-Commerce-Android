package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.ProductsContract;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;

public class ProductsPresenter implements ProductsContract.Presenter {

    ProductsContract.View mView;
    ApiDataManager mApiDataManager;

    public ProductsPresenter(ProductsContract.View mView) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getProducts(String categoryId) {
        mView.showLoading();
        mApiDataManager.getProductsByCategory(this,categoryId);
    }

    @Override
    public void onProductsResultResponse(SearchResponse searchResponse) {
        mView.showProductsResponse(searchResponse);
    }
}
