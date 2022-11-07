
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class MultiLanguageUrlList {

    @SerializedName("language")
    private String mLanguage;
    @SerializedName("languageUrl")
    private String mLanguageUrl;

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getLanguageUrl() {
        return mLanguageUrl;
    }

    public void setLanguageUrl(String languageUrl) {
        mLanguageUrl = languageUrl;
    }

}
