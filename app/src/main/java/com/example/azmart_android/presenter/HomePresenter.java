package com.example.azmart_android.presenter;

import android.content.Context;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.HomeContract;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.NetworkManager;

import java.util.ArrayList;

public class HomePresenter implements HomeContract.Presenter {

    HomeContract.View mView;
    ApiDataManager mApiDataManager;
    Context mContext;
    public ArrayList<String> dealsList = new ArrayList();

    public HomePresenter() {
        dealsList.add("https://img.freepik.com/premium-vector/special-offer-sale-discount-banner_180786-46.jpg?w=2000");
        dealsList.add("https://images.unsplash.com/photo-1621551122354-e96737d64b70?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080");
        dealsList.add("https://images.unsplash.com/photo-1621616875450-79f024a8c42c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080");
        dealsList.add("https://images.unsplash.com/photo-1621687947404-e41b3d139088?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080");
    }

    @Override
    public void onApiError(String data) {

    }

    @Override
    public void CallLOGIN(String user, String password) {
        if (NetworkManager.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
        } else mView.showWarningMessage(mContext.getResources().getString(R.string.no_internet));
    }
}
