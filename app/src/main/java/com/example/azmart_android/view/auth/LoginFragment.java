package com.example.azmart_android.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.azmart_android.R;
import com.example.azmart_android.data.preference.SessionManager;
import com.example.azmart_android.databinding.FragmentLoginBinding;
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

public class LoginFragment extends BaseFragment {
    private FragmentLoginBinding binding;
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
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.buttonLogin.setOnClickListener(v -> validateFields());
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
        if (NetworkManager.isNetworkAvailable(requireContext())) {
            showLoadingDialog(requireContext());
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            hideLoadingDialog();
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                sessionManager.setLogin(true);
                                showToast(requireContext(), "Login Successfully");
                                startActivity(new Intent(requireContext(), HomeActivity.class));
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            hideLoadingDialog();
                            showSnackBar(requireView(), "Invalid credentials, Please register to continue");
                        }
                    });
        } else
            showSnackBar(requireView(), getResources().getString(R.string.no_internet));
    }
}