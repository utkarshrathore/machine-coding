package com.cabservice.services;

import com.cabservice.models.Cab;

public interface DriverService {
    String registerDriver(
            String name, String mobileNumber, String email, String address, Cab cab, boolean isAvailable,
            CoreDataService coreDataService);
    void updateAvailability(String driverId, boolean newAvailability, CoreDataService coreDataService);
}