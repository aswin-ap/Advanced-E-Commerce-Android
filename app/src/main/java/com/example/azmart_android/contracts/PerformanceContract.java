package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.CartModel;
import com.example.azmart_android.data.model.PerformanceModel;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public interface PerformanceContract {

    interface View extends BaseView {
        void showPerformance(List<PerformanceModel> performanceModelList);
    }

    interface Presenter extends BasePresenter {
      void getPerformance();
    }

}
