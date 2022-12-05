package com.example.azmart_android.presenter;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.PerformanceContract;
import com.example.azmart_android.data.model.PerformanceBannerModel;
import com.example.azmart_android.data.model.PerformanceModel;
import com.example.azmart_android.network.api_manager.ApiDataManager;
import com.example.azmart_android.utils.SecureCompatibleEncryptionExamples;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class PerformancePresenter implements PerformanceContract.Presenter {
    public List<PerformanceBannerModel> performanceModelList = new ArrayList<>();
    PerformanceContract.View mView;
    ApiDataManager mApiDataManager;
    Context context;

    public PerformancePresenter(PerformanceContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        mApiDataManager = new ApiDataManager();

        performanceModelList.add(new PerformanceBannerModel(R.drawable.encryption_1, "Encryption Algorithm"));
        performanceModelList.add(new PerformanceBannerModel(R.drawable.encryption_2, "Cryptography encoding process"));
        performanceModelList.add(new PerformanceBannerModel(R.drawable.encryption_3, "Database encryption"));
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getPerformance() {
        List<PerformanceModel> performanceList = new ArrayList<>();
        new Handler().postDelayed(() -> {
            try {
                try {
                    long timeTook;

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        timeTook = System.currentTimeMillis();

                        String encryptedValue = SecureCompatibleEncryptionExamples.encryptString("Some Text Line !", "pass123");
                        String decryptedValue = SecureCompatibleEncryptionExamples.decryptString(
                                encryptedValue, "pass123");

                        timeTook = System.currentTimeMillis();
                        performanceList.add(new PerformanceModel("AES/GCM/NoPadding", timeTook));
                        Log.d("Encryption", "testMyEncryption: " + "Transformation" + "AES/NOPADDING" + "\n" + "Enc (bytes displayed as ISO-8859-1):" + encryptedValue + "\n" + "Dec: " + decryptedValue + "\n" + timeTook + "ms");

                    }
                } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
                    e.printStackTrace();
                }

                performanceList.add(testFastestCipher("AES/ECB/PKCS5Padding", "AES", false));
                performanceList.add(testFastestCipher("AES/CBC/PKCS5Padding", "AES", true));
                performanceList.add(testFastestCipher("AES/CFB/PKCS5Padding", "AES", true));
                performanceList.add(testFastestCipher("AES/OFB/PKCS5Padding", "AES", true));
                performanceList.add(testFastestCipher("AES/CTR/PKCS5Padding", "AES", true));

                performanceList.add(testFastestCipher("Blowfish/ECB/PKCS5Padding", "Blowfish", false));
                performanceList.add(testFastestCipher("Blowfish/CBC/PKCS5Padding", "Blowfish", true));
                performanceList.add(testFastestCipher("Blowfish/CFB/PKCS5Padding", "Blowfish", true));
                performanceList.add(testFastestCipher("Blowfish/OFB/PKCS5Padding", "Blowfish", true));
                performanceList.add(testFastestCipher("Blowfish/CTR/PKCS5Padding", "Blowfish", true));
                performanceList.add(testFastestCipher("Blowfish/CTR/PKCS5Padding", "Blowfish", true));

                if (Build.VERSION.SDK_INT >= 28) {
                    performanceList.add(testFastestCipher("ChaCha20/None/NoPadding", "ChaCha20", true));
                }

                Log.d("PerformanceList", "getPerformance: " + performanceList.toString());
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
            if (performanceList.size() > 0) {
                mView.showPerformance(performanceList);
            }
        }, 2000);

    }

    private PerformanceModel testFastestCipher(String transformation, String keyAlgorithm, boolean requiresIV) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        final String PLAY_TEST_TEXT = "Some Text Line !";

        Cipher cipherEnc = Cipher.getInstance(transformation);
        Cipher cipherDec = Cipher.getInstance(transformation);
        String secretKeyString;

        if (keyAlgorithm.equals("ChaCha20")) {
            secretKeyString = "aNdRgUkXp2s5v8y/B?E(G+KbPeShVmYq";
        } else
            secretKeyString = "C&E)H@McQfTjWnZr";

        SecretKeySpec secretKey = new SecretKeySpec(secretKeyString.getBytes(), keyAlgorithm);

        if (requiresIV) {
            String ivKey;
            if (keyAlgorithm.equals("Blowfish")) {
                ivKey = "12345678";
            } else if (keyAlgorithm.equals("ChaCha20")) {
                ivKey = "123456789123";
            } else {
                ivKey = "1234567891230000";
            }

            IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes());
            cipherEnc.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            cipherDec.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        } else {
            cipherEnc.init(Cipher.ENCRYPT_MODE, secretKey);
            cipherDec.init(Cipher.DECRYPT_MODE, secretKey);
        }

        String encMsg = "";
        String decMsg = "";
        long timeTook;

        timeTook = System.currentTimeMillis();

        for (int i = 0; i <= 5000; i++) {
            encMsg = encryptMsg(PLAY_TEST_TEXT, cipherEnc);
            decMsg = decryptMsg(encMsg, cipherDec);
        }

        timeTook = System.currentTimeMillis();
        Log.d("Encryption", "testFastestCipher: " + "Transformation" + transformation + "\n" + "Enc (bytes displayed as ISO-8859-1):" + encMsg + "\n" + "Dec: " + decMsg + "\n" + timeTook + "ms");
        return new PerformanceModel(transformation, timeTook);
    }

    private String encryptMsg(String message, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return new String(bytes, StandardCharsets.ISO_8859_1);
    }

    private String decryptMsg(String cipherText, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        byte[] encryptedString = cipherText.getBytes(StandardCharsets.ISO_8859_1);
        return new String(cipher.doFinal(encryptedString), StandardCharsets.UTF_8);
    }
}
