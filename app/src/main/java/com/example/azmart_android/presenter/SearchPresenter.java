package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.SearchContract;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;

public class SearchPresenter implements SearchContract.Presenter {
    SearchContract.View mView;
    ApiDataManager mApiDataManager;

    public SearchPresenter(SearchContract.View mView) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);
    }

    @Override
    public void getItemsBySearch(String text) {
        mView.showLoading();
        mApiDataManager.searchItemsByName(this, text);
    }

    @Override
    public void onSearchResultResponse(SearchResponse onSearchResponse) {

        if (onSearchResponse.getDocs().size() > 0) {
            mView.showSearchResponse(onSearchResponse);
        } else
            mView.showApiErrorWarning("Oops! No results found");
    }
}
