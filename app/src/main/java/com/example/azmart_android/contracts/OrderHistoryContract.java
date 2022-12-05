package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.OrderHistoryModel;
import com.example.azmart_android.data.model.SearchResponse;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public interface OrderHistoryContract {

    interface View extends BaseView {
        void showOrderHistoryResponse(List<OrderHistoryModel> orderHistoryModels);
    }

    interface Presenter extends BasePresenter {
        void getOrdersHistory(String categoryId);
        void onOrderHistoryResultResponse(QuerySnapshot documentSnapshot);
    }

}
