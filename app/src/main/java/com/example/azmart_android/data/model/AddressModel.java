package com.example.azmart_android.data.model;

import com.google.gson.Gson;

public class AddressModel {
    private String fullName;
    private String phoneNumber;
    private String pinCode;
    private String state;
    private String city;
    private String houseNo;
    private String roadName;

    public AddressModel(String fullName, String phoneNumber, String pinCode, String state, String city, String houseNo, String roadName) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
        this.houseNo = houseNo;
        this.roadName = roadName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }


    @Override
    public String toString() {
        return "AddressModel{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", roadName='" + roadName + '\'' +
                '}';
    }
}
