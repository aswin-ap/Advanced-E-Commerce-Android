package com.example.azmart_android.presenter;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.example.azmart_android.contracts.OrderHistoryContract;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.data.model.OrderHistoryModel;
import com.example.azmart_android.data.model.SearchResponse;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.SecureCompatibleEncryptionExamples;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class OrderHistoryPresenter implements OrderHistoryContract.Presenter {

    OrderHistoryContract.View mView;
    ApiDataManager mApiDataManager;

    public OrderHistoryPresenter(OrderHistoryContract.View mView, Context context) {
        this.mView = mView;
        mApiDataManager = new ApiDataManager();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }


    @Override
    public void getOrdersHistory(String userId) {
        mView.showLoading();
        mApiDataManager.getOrdersHistory(this,userId);
    }

    @Override
    public void onOrderHistoryResultResponse(QuerySnapshot documentSnapshot) {
        mView.hideLoading();
        List<OrderHistoryModel> modelList = new ArrayList<>();
        for (QueryDocumentSnapshot queryDocumentSnapshot : documentSnapshot) {
            String decryptedValue;
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    decryptedValue = SecureCompatibleEncryptionExamples.decryptString(
                            queryDocumentSnapshot.getString("order"),
                            Objects.requireNonNull(queryDocumentSnapshot.getString("password")));

                    OrderHistoryModel model = new Gson().fromJson(decryptedValue, OrderHistoryModel.class);
                    modelList.add(model);
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
        }
        Log.e("result", modelList.toString());
        mView.showOrderHistoryResponse(modelList);
    }
}
