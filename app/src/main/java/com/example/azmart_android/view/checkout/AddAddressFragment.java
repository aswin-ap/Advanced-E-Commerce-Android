package com.example.azmart_android.view.checkout;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.navigation.Navigation;

import com.example.azmart_android.contracts.AddressContract;
import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.databinding.FragmentAddAddressBinding;
import com.example.azmart_android.presenter.AddressPresenter;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.units.qual.A;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

public class AddAddressFragment extends BaseFragment implements AddressContract.View {
    private FragmentAddAddressBinding binding;
    AddressPresenter addressPresenter;
    FirebaseUser currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddAddressBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        addressPresenter = new AddressPresenter(this, requireContext());
        binding.btnSaveAddress.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if (isFormValid()) {
                    AddressModel model = new AddressModel(
                            binding.etFullName.getText().toString(),
                            binding.etPhoneNumber.getText().toString(),
                            binding.etPinCode.getText().toString(),
                            binding.etState.getText().toString(),
                            binding.etCity.getText().toString(),
                            binding.etHouseNo.getText().toString(),
                            binding.etRoadName.getText().toString()
                    );
                    try {
                        addressPresenter.saveAddress(model, currentUser.getUid());
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
        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etFullName.getText()).toString())) {
            binding.fullNameLayout.setError("Please enter valid name");
            return false;
        } else
            binding.fullNameLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etPhoneNumber.getText()).toString())) {
            binding.phoneLayout.setError("Please enter valid Phone number");
            return false;
        } else
            binding.phoneLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etPinCode.getText()).toString())) {
            binding.pinCodeLayout.setError("Please enter valid Pin code");
            return false;
        } else
            binding.pinCodeLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etState.getText()).toString())) {
            binding.stateLayout.setError("Please enter sate");
            return false;
        } else
            binding.stateLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etCity.getText()).toString())) {
            binding.cityLayout.setError("Please enter city");
            return false;
        } else
            binding.cityLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etHouseNo.getText()).toString())) {
            binding.houseLayout.setError("Please enter required field");
            return false;
        } else
            binding.houseLayout.setError(null);

        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etRoadName.getText()).toString())) {
            binding.roadLayout.setError("Please enter required field");
            return false;
        } else
            binding.roadLayout.setError(null);

        return true;
    }

    @Override
    public void showSuccessResponse(String message) {
        showSnackBar(requireView(), message);
        Navigation.findNavController(requireView()).popBackStack();
    }

    @Override
    public void showAddressResponse(List<AddressModel> addressModelList) {
    }

    @Override
    public void showLoading() {
        super.showLoadingDialog(requireContext());
    }

    @Override
    public void hideLoading() {
        super.hideLoadingDialog();
    }

    @Override
    public void showApiErrorWarning(String string) {
        showToast(requireContext(), string);

    }
}