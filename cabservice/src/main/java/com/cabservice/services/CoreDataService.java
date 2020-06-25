package com.cabservice.services;

import com.cabservice.models.Cab;
import com.cabservice.models.Driver;
import com.cabservice.models.User;

import java.util.Map;

public interface CoreDataService {
    void addUser(User user);
    void addDriver(Driver driver);
    User getUser(String userId);
    Driver getDriver(String driverId);
    Cab getCab(String cabId);
    Map<String, Cab> getCabMap();
}