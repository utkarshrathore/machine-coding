package com.cabservice.services.impl;

import com.cabservice.models.Cab;
import com.cabservice.models.Driver;
import com.cabservice.models.User;
import com.cabservice.services.CoreDataService;

import java.util.HashMap;
import java.util.Map;

public class CoreDataServiceImpl implements CoreDataService {
    private Map<String, User> userMap;
    private Map<String, Driver> driverMap;
    private Map<String, Cab> cabMap;

    private CoreDataServiceImpl() {
        this.driverMap = new HashMap<String, Driver>();
        this.userMap = new HashMap<String, User>();
        this.cabMap = new HashMap<String, Cab>();
    }

    public void addUser(User user) {
        this.userMap.put(user.getUuid(), user);
    }

    public void addDriver(Driver driver) {
        this.driverMap.put(driver.getUuid(),driver);
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }

    public Driver getDriver(String driverId) {
        return driverMap.get(driverId);
    }

    public Cab getCab(String cabId) {
        return cabMap.get(cabId);
    }
}