package com.cabservice.models;

import java.util.UUID;

public class Cab {
    private String uuid;
    private String make;
    private String model;
    private String registrationNumber;
    private String color;
    private int ageInYears;
    private Location currentLocation;

    public Cab(String make, String model, String registrationNumber, String color, int ageInYears) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.ageInYears = ageInYears;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", ageInYears=" + ageInYears +
                '}';
    }
}
