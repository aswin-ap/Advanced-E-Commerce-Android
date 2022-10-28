package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.SearchResponse;

public interface SearchContract {
    interface View extends BaseView {
        void showSearchResponse(SearchResponse searchResponse);
    }

    interface Presenter extends BasePresenter {
        void getItemsBySearch(String text);

        void onSearchResultResponse(SearchResponse onSearchResponse);
    }
}
