package com.example.azmart_android.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.azmart_android.R;
import com.example.azmart_android.data.prefrence.SessionManager;
import com.example.azmart_android.databinding.FragmentLoginBinding;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.utils.Validation;
import com.example.azmart_android.view.BaseFragment;
import com.example.azmart_android.view.home.HomeActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class LoginFragment extends BaseFragment {
    private static final int RC_SIGN_IN = 234;
    GoogleSignInClient mGoogleSignInClient;
    private FragmentLoginBinding binding;
    private FirebaseAuth mAuth;
    private SessionManager sessionManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        sessionManager = new SessionManager(requireContext());
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso);
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

        binding.btSignIn.setOnClickListener(v -> {
            doSignInWithGoogle();
        });

    }

    private void doSignInWithGoogle() {
        showLoadingDialog(requireContext());

        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                hideLoadingDialog();
                showSnackBar(requireView(), "Sign in with google failed!");
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);

        //Now using firebase we are signing in the user here
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        hideLoadingDialog();
                        Log.d("TAG", "signInWithCredential:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        sessionManager.setLogin(true);
                        showToast(requireContext(), "Login Successfully");
                        startActivity(new Intent(requireContext(), HomeActivity.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        hideLoadingDialog();
                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                        showToast(requireContext(), "Authentication failed.");
                    }
                });
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