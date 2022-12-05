package com.example.azmart_android.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.azmart_android.R;
import com.example.azmart_android.adapter.ProfileAdapter;
import com.example.azmart_android.data.preference.SessionManager;
import com.example.azmart_android.databinding.FragmentProfileBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {
    GoogleSignInClient mGoogleSignInClient;
    private FragmentProfileBinding binding;
    private FirebaseAuth mAuth;
    private ProfileAdapter adapter;
    private SessionManager sessionManager;
    private String[] settingsList = {"My Profile", "Order History", "Encryption Performance", "Settings",};

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        adapter = new ProfileAdapter(requireActivity(), settingsList);
        binding.profileList.setAdapter(adapter);
        binding.btnLogout.setOnClickListener(v -> {
            showLogoutDialog();
        });
        binding.profileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                navigate(i);
            }
        });
    }

    private void navigate(int i) {
        switch (i) {
            case 1: {
                Navigation.findNavController(requireView()).navigate(R.id.action_profileFragment_to_orderHistoryFragment);
            }
            break;
            case 2: {
                Navigation.findNavController(requireView()).navigate(R.id.action_profileFragment_to_performanceCheckFragment);
            }
            break;
            default: {
            }

        }
    }

    private void showLogoutDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
        builder.setTitle("Logout");
        builder.setIcon(R.drawable.app_main);
        builder.setMessage("Are you sure want to Logout ?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            sessionManager.clear();
            mAuth.signOut();
            mGoogleSignInClient.signOut();
            Intent intent = new Intent(requireContext(), AuthActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            //requireActivity().finishAffinity();
            dialogInterface.dismiss();
        }).setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss()).show();

    }
}