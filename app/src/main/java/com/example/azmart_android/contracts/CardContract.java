package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.CardsModel;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface CardContract {

    interface View extends BaseView {
        void showSuccessResponse(String message);
        void showCardResponse(List<CardsModel> addressModelList);
    }

    interface Presenter extends BasePresenter {
        void saveCard(CardsModel cardModel,String userId) throws UnsupportedEncodingException;
        void onSaveCardResponse(String message);
        void getCard(String userId);
        void onCardResponse(QuerySnapshot documentSnapshot);
    }

}
