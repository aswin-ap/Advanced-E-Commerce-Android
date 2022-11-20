package com.example.azmart_android.data.model;

public class CartModel {
    private String id;
    private String title;
    private String rating;
    private String price;
    private int quantity;
    private String imageUrl;
    private String userId;

    public CartModel(String id, String title, String rating, String price, int quantity, String imageUrl, String userId) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
