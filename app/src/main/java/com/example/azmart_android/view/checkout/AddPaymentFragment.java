package com.example.azmart_android.view.checkout;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.CardContract;
import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.databinding.FragmentAddPaymentBinding;
import com.example.azmart_android.presenter.CardPresenter;
import com.example.azmart_android.view.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class AddPaymentFragment extends BaseFragment implements CardContract.View {

    private FragmentAddPaymentBinding binding;
    private CardPresenter cardPresenter;
    FirebaseUser currentUser;

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
                            binding.spCardType.getText().toString(),
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

    }

    private boolean isFormValid() {

        return true;
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