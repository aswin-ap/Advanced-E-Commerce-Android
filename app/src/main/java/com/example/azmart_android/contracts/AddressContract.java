package com.example.azmart_android.contracts;

import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.data.model.CartModel;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface AddressContract {

    interface View extends BaseView {
        void showSuccessResponse(String message);
        void showAddressResponse(List<AddressModel> addressModelList);
    }

    interface Presenter extends BasePresenter {
        void saveAddress(AddressModel addressModel,String userId) throws UnsupportedEncodingException;
        void onSaveAddressResponse(String message);
        void getAddress(String userId);
        void onAddressResponse(QuerySnapshot documentSnapshot);
    }

}
