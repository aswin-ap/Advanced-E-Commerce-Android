package com.example.azmart_android.data.model;

public class PerformanceBannerModel {
    private int imageId;
    private String description;

    public PerformanceBannerModel(int imageId, String description) {
        this.imageId = imageId;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
