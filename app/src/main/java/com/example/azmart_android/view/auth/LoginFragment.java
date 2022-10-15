package com.example.azmart_android.view.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.azmart_android.databinding.FragmentLoginBinding;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginFragment extends BaseFragment {
    private FragmentLoginBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        initView();
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
        return binding.getRoot();
    }

    private void initView() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void validateFields() {
        if (!Validation.isValidEmail(Objects.requireNonNull(binding.etEmail.getText()).toString())) {
            binding.emailTextLayout.setError("Please enter valid email");
        } else if (!Validation.isNotNullOrEmpty(binding.etPassword.getText().toString())) {
            binding.passwordTxtLayout.setError("Please enter valid password");
            binding.emailTextLayout.setError(null);
        } else {
            binding.passwordTxtLayout.setError(null);
            doLogin(binding.etEmail.getText().toString(), binding.etPassword.getText().toString());
        }
    }

    private void doLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            showSnackBar(requireView(), "Login Successfully");
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        showSnackBar(requireView(), "Invalid credentials, Please register to continue");
                    }
                });
    }
}