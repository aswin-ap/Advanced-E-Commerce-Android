
package com.example.azmart_android.data.model.ProductDetails;


import com.google.gson.annotations.SerializedName;


public class Env {

    @SerializedName("valMap")
    private ValMap mValMap;
    @SerializedName("zone")
    private String mZone;

    public ValMap getValMap() {
        return mValMap;
    }

    public void setValMap(ValMap valMap) {
        mValMap = valMap;
    }

    public String getZone() {
        return mZone;
    }

    public void setZone(String zone) {
        mZone = zone;
    }

}
