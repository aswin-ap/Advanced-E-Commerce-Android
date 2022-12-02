package com.example.azmart_android.presenter;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import com.example.azmart_android.R;
import com.example.azmart_android.contracts.PerformanceContract;
import com.example.azmart_android.data.model.PerformanceModel;
import com.example.azmart_android.network.api_manager.ApiDataManager;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class PerformancePresenter implements PerformanceContract.Presenter {
    public List<PerformanceModel> performanceModelList = new ArrayList<>();
    PerformanceContract.View mView;
    ApiDataManager mApiDataManager;
    Context context;

    public PerformancePresenter(PerformanceContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        mApiDataManager = new ApiDataManager();

        performanceModelList.add(new PerformanceModel(R.drawable.encryption_1, "Encryption Algorithm"));
        performanceModelList.add(new PerformanceModel(R.drawable.encryption_2, "Cryptography encoding process"));
        performanceModelList.add(new PerformanceModel(R.drawable.encryption_3, "Database encryption"));
    }

    @Override
    public void onApiError(String data) {
        mView.hideLoading();
        mView.showApiErrorWarning(data);

    }

    @Override
    public void getPerformance() {
        new Handler().postDelayed(() -> {
            try {
                testFastestCipher("AES/ECB/PKCS5Padding", "AES", false);
                testFastestCipher("AES/CBC/PKCS5Padding", "AES", true);
                testFastestCipher("AES/CFB/PKCS5Padding", "AES", true);
                testFastestCipher("AES/OFB/PKCS5Padding", "AES", true);
                testFastestCipher("AES/CTR/PKCS5Padding", "AES", true);

                testFastestCipher("Blowfish/ECB/PKCS5Padding", "Blowfish", false);
                testFastestCipher("Blowfish/CBC/PKCS5Padding", "Blowfish", true);
                testFastestCipher("Blowfish/CFB/PKCS5Padding", "Blowfish", true);
                testFastestCipher("Blowfish/OFB/PKCS5Padding", "Blowfish", true);
                testFastestCipher("Blowfish/CTR/PKCS5Padding", "Blowfish", true);
                testFastestCipher("Blowfish/CTR/PKCS5Padding", "Blowfish", true);

                if (Build.VERSION.SDK_INT >= 28) {
                    testFastestCipher("ChaCha20/None/NoPadding", "ChaCha20", true);
                }
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
        }, 2000);
    }

    private void testFastestCipher(String transformation, String keyAlgorithm, boolean requiresIV) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

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
