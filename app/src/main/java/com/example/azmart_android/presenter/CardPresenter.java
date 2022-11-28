package com.example.azmart_android.presenter;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.azmart_android.contracts.AddressContract;
import com.example.azmart_android.contracts.CardContract;
import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.utils.PasswordGenerator;
import com.example.azmart_android.utils.SecureCompatibleEncryptionExamples;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CardPresenter implements CardContract.Presenter {
    CardContract.View mView;
    ApiDataManager mApiDataManager;
    Context context;
    PasswordGenerator passwordGenerator;

    public CardPresenter(CardContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        mApiDataManager = new ApiDataManager();
        passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .usePunctuation(true)
                .useUpper(true)
                .build();
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void saveCard(CardsModel cardModel, String userId) throws UnsupportedEncodingException {
        if (NetworkManager.isNetworkAvailable(context)) {
            mView.showLoading();

            String password = passwordGenerator.generate(8);
            String jsonModel = new Gson().toJson(cardModel);

            String encryptedValue = null;
            try {
                encryptedValue = SecureCompatibleEncryptionExamples.encryptString(jsonModel, password);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("card", encryptedValue);
            dataMap.put("password", password);
            dataMap.put("user_id", userId);

            mApiDataManager.addUserCard(this, dataMap);
        } else
            mView.showApiErrorWarning("Oops! No internet available");
    }

    @Override
    public void onSaveCardResponse(String message) {
        mView.hideLoading();
        mView.showSuccessResponse(message);
    }

    @Override
    public void getCard(String userId) {
        if (NetworkManager.isNetworkAvailable(context)) {
            mView.showLoading();

            mApiDataManager.getCard(this, userId);
        } else
            mView.showApiErrorWarning("Oops! No internet available");
    }

    @Override
    public void onCardResponse(QuerySnapshot documentSnapshot) {
        mView.hideLoading();
        List<CardsModel> modelList = new ArrayList<>();
        for (QueryDocumentSnapshot queryDocumentSnapshot : documentSnapshot) {
            String decryptedValue;
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    decryptedValue = SecureCompatibleEncryptionExamples.decryptString(
                            queryDocumentSnapshot.getString("card"),
                            Objects.requireNonNull(queryDocumentSnapshot.getString("password")));

                    CardsModel model = new Gson().fromJson(decryptedValue, CardsModel.class);
                    modelList.add(model);
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
        }
        mView.showCardResponse(modelList);
    }
}
