package com.example.azmart_android.presenter;

import com.example.azmart_android.contracts.HomeContract;
import com.example.azmart_android.data.model.CategoriesResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.NetworkManager;

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
        dealsList.add("https://images.unsplash.com/photo-1621551122354-e96737d64b70?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080");
        dealsList.add("https://images.unsplash.com/photo-1621616875450-79f024a8c42c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080");
        dealsList.add("https://images.unsplash.com/photo-1621687947404-e41b3d139088?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080");
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);
    }

    @Override
    public void getCategories() {
      /*  if (NetworkManager.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
            mApiDataManager.LoginUser(user, password, this);
        } else mView.showWarningMessage(mContext.getResources().getString(R.string.no_network));*/
        mView.showLoading();
      // mApiDataManager.getCategories(this);
       mApiDataManager.parallelApiCall();
    }

    @Override
    public void onResultCategoriesResponse(List<CategoriesResponse> categoriesResponse) {
        mView.hideLoading();
        if (categoriesResponse.size() > 0) {
            mView.showCategoriesResponse(categoriesResponse);
        }
    }

}
