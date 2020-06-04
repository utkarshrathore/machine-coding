package com.cabservice.services.impl;

import com.cabservice.models.Cab;
import com.cabservice.models.Driver;
import com.cabservice.services.CoreDataService;
import com.cabservice.services.DriverService;

public class DriverServiceImpl implements DriverService {

    public String registerDriver(
            String name, String mobileNumber, String email, String address, Cab cab,
            boolean isAvailable, CoreDataService coreDataService)
    {
        Driver driver = new Driver(name, mobileNumber, email, address, cab, isAvailable);
        coreDataService.addDriver(driver);
        return driver.getUuid();
    }

    public void updateAvailability(String driverId, boolean newAvailability, CoreDataService coreDataService) {
        coreDataService.getDriver(driverId).setAvailable(newAvailability);
    }
}