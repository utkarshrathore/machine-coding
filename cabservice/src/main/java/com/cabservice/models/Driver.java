package com.cabservice.models;

public class Driver extends User {
    private Cab cabOwned;
    private boolean isAvailable;

    public Driver(String userName, String userMobileNumber, String userEmail, String userAddress, Cab cabOwned, boolean isAvailable) {
        super(userName, userMobileNumber, userEmail, userAddress);
        this.cabOwned = cabOwned;
        this.isAvailable = isAvailable;
    }

    public Cab getCabOwned() {
        return cabOwned;
    }

    public void setCabOwned(Cab cabOwned) {
        this.cabOwned = cabOwned;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "cabOwned=" + cabOwned +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
