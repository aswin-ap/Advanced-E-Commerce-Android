
package com.example.azmart_android.data.model.ProductDetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProductSmallImageUrls {

    @SerializedName("string")
    private List<String> mString;

    public List<String> getString() {
        return mString;
    }

    public void setString(List<String> string) {
        mString = string;
    }

}
