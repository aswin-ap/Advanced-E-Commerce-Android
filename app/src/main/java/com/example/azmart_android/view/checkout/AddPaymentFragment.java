package com.example.azmart_android.view.checkout;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.azmart_android.contracts.CardContract;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.databinding.FragmentAddPaymentBinding;
import com.example.azmart_android.presenter.CardPresenter;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

public class AddPaymentFragment extends BaseFragment implements CardContract.View , AdapterView.OnItemSelectedListener {

    private FragmentAddPaymentBinding binding;
    private CardPresenter cardPresenter;
    FirebaseUser currentUser;
    String cardType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAddPaymentBinding.inflate(inflater,container,false);

        initView();

        return binding.getRoot();
    }

    private void initView() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        cardPresenter=new CardPresenter(this,requireContext());
        binding.btnSaveCard.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if (isFormValid()) {
                    CardsModel model = new CardsModel(
                            binding.etCardNumber.getText().toString(),
                            binding.etCardHolderName.getText().toString(),
                            cardType,
                            binding.etExpiryDate.getText().toString(),
                            binding.etCvv.getText().toString()
                    );
                    try {
                        cardPresenter.saveCard(model, currentUser.getUid());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        binding.ivBack.setOnClickListener(v -> {
            Navigation.findNavController(requireView()).popBackStack();
        });

        String[] cards = { "Select Card Type","Visa Card","Master Card","Rupay Card"};
        ArrayAdapter card =new ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,cards);
        card.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spCardType.setAdapter(card);

    }

    private boolean isFormValid() {
        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etCardNumber.getText()).toString())) {
            binding.fullNameLayout.setError("Please enter valid card number");
            return false;
        } else
            binding.fullNameLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etCardHolderName.getText()).toString())) {
            binding.etCardHolderName.setError("Please enter valid holder name");
            return false;
        } else
            binding.etCardHolderName.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etExpiryDate.getText()).toString())) {
            binding.etExpiryDate.setError("Please select a valid date");
            return false;
        } else
            binding.etExpiryDate.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etCvv.getText()).toString())) {
            binding.etCvv.setError("Please enter valid cvv number");
            return false;
        } else
            binding.etCvv.setError(null);

//        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(cardType).toString())) {
////            binding.llCardType.setError("Please Select card type");
//            return false;
//        } else if(cardType=="Select Card Type"){
////            binding.phoneLayout.setError("Please Select card type");
//            return false;
//        }else
//            binding.phoneLayout.setError(null);

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        cardType=item;
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showApiErrorWarning(String string) {
        showToast(requireContext(), string);
    }

    @Override
    public void showSuccessResponse(String message) {
        showSnackBar(requireView(), message);
        Navigation.findNavController(requireView()).popBackStack();
    }

    @Override
    public void showCardResponse(List<CardsModel> addressModelList) {

    }
}