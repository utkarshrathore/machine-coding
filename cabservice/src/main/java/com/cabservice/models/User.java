package com.cabservice.models;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class User {
    private String uuid;
    private String userName;
    private String userMobileNumber;
    private String userEmail;
    private String userAddress;
    private List<Trip> tripList;

    public User(String userName, String userMobileNumber, String userEmail, String userAddress) {
        this.uuid = UUID.randomUUID().toString();
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.tripList = new LinkedList<Trip>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                ", userMobileNumber='" + userMobileNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
