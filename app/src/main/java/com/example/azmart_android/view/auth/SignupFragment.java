package com.example.azmart_android.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.azmart_android.R;
import com.example.azmart_android.data.prefrence.SessionManager;
import com.example.azmart_android.databinding.FragmentSignupBinding;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;


public class SignupFragment extends BaseFragment {
    private FragmentSignupBinding binding;
    private FirebaseAuth mAuth;
    private SessionManager sessionManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        sessionManager = new SessionManager(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFieldsAndSignUp();
            }
        });
    }

    private void validateFieldsAndSignUp() {
        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.etName.getText()).toString())) {
            binding.nameLayout.setError("Please enter valid name");
        } else if (!Validation.isValidEmail(binding.etEmail.getText().toString())) {
            binding.emailLayout.setError("Please enter valid email-id");
            binding.nameLayout.setError(null);
        } else if (!Validation.isNotNullOrEmpty(binding.etMobile.getText().toString())) {
            binding.mobileLayout.setError("Please enter valid mobile");
            binding.emailLayout.setError(null);
        } else if (!Validation.isNotNullOrEmpty(binding.etPassword.getText().toString())) {
            binding.passwordLayout.setError("Please enter valid password");
            binding.mobileLayout.setError(null);
        } else if (!Validation.isValidPassword(binding.etPassword.getText().toString())) {
            binding.passwordLayout.setError("Please enter minimum 6 characters for password");
        } else if (!Validation.isPasswordConfirm(binding.etPassword.getText().toString(), binding.etConfirmPass.getText().toString())) {
            binding.confirmPasswordLayout.setError("Password confirmation failed");
            binding.passwordLayout.setError(null);
        } else {
            binding.confirmPasswordLayout.setError(null);
            doRegister(binding.etEmail.getText().toString(), binding.etPassword.getText().toString());
        }
    }

    private void doRegister(String email, String password) {
        if (NetworkManager.isNetworkAvailable(requireContext())) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                sessionManager.setLogin(true);
                                showToast(requireContext(), "Registered Successfully");
                                startActivity(new Intent(requireContext(), HomeActivity.class));
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            showSnackBar(requireView(), "Registration failed. Please try again later");
                        }
                    });
        } else
            showSnackBar(requireView(), getResources().getString(R.string.no_internet));

    }
}