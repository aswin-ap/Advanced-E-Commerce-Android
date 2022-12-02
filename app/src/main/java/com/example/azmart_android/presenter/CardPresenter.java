package com.example.azmart_android.presenter;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.AddressContract;
import com.example.azmart_android.contracts.CardContract;
import com.example.azmart_android.data.model.AddressModel;
import com.example.azmart_android.data.model.CardsModel;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.NetworkManager;
import com.example.azmart_android.utils.PasswordGenerator;
import com.example.azmart_android.utils.SecureCompatibleEncryptionExamples;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CardPresenter implements CardContract.Presenter {
    CardContract.View mView;
    ApiDataManager mApiDataManager;
    Context context;
    PasswordGenerator passwordGenerator;
    BiometricPrompt biometricPrompt;
    private CancellationSignal cancellationSignal;

    public CardPresenter(CardContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        mApiDataManager = new ApiDataManager();
        passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .usePunctuation(true)
                .useUpper(true)
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            biometricPrompt = new BiometricPrompt.Builder(context)
                    .setTitle("Enter phone screen lock pattern, PIN, password or fingerprint")
                    .setSubtitle("Confirm payment " + context.getResources().getString(R.string.app_name))
                    .setDescription("Authentication")
                    .setNegativeButton("Cancel", context.getMainExecutor(), (dialogInterface, i) -> {

                    }).build();
        }

        cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(() -> {
            mView.showAuthenticationWarning("Authentication was cancelled by the user");
        });

    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void saveCard(CardsModel cardModel, String userId) throws UnsupportedEncodingException {
        if (NetworkManager.isNetworkAvailable(context)) {
            mView.showLoading();

            String password = passwordGenerator.generate(8);
            String jsonModel = new Gson().toJson(cardModel);

            String encryptedValue = null;
            try {
                encryptedValue = SecureCompatibleEncryptionExamples.encryptString(jsonModel, password);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("card", encryptedValue);
            dataMap.put("password", password);
            dataMap.put("user_id", userId);

            mApiDataManager.addUserCard(this, dataMap);
        } else
            mView.showApiErrorWarning("Oops! No internet available");
    }

    @Override
    public void onSaveCardResponse(String message) {
        mView.hideLoading();
        mView.showSuccessResponse(message);
    }

    @Override
    public void getCard(String userId) {
        if (NetworkManager.isNetworkAvailable(context)) {
            mView.showLoading();

            mApiDataManager.getCard(this, userId);
        } else
            mView.showApiErrorWarning("Oops! No internet available");
    }

    @Override
    public void onCardResponse(QuerySnapshot documentSnapshot) {
        mView.hideLoading();
        List<CardsModel> modelList = new ArrayList<>();
        for (QueryDocumentSnapshot queryDocumentSnapshot : documentSnapshot) {
            String decryptedValue;
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    decryptedValue = SecureCompatibleEncryptionExamples.decryptString(
                            queryDocumentSnapshot.getString("card"),
                            Objects.requireNonNull(queryDocumentSnapshot.getString("password")));

                    CardsModel model = new Gson().fromJson(decryptedValue, CardsModel.class);
                    modelList.add(model);
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
        }
        mView.showCardResponse(modelList);
        Log.e("result", modelList.toString());
    }

    @Override
    public void authenticate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (checkBiometricSupport()) {
                biometricPrompt.authenticate(cancellationSignal, context.getMainExecutor(), new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                        mView.showAuthenticationWarning("Authentication error :" + errString);
                    }

                    @Override
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        mView.showAuthenticationWarning("Authentication Success");
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                    }
                });
            } else
                mView.showAuthenticationWarning("Fingerprint has not been enabled in settings");
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private boolean checkBiometricSupport() {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (!keyguardManager.isKeyguardSecure()) {
            return false;
        }
        return ActivityCompat.checkSelfPermission(context, android.Manifest.permission.USE_BIOMETRIC) == PackageManager.PERMISSION_GRANTED;
    }

}
