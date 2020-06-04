package com.cabservice.services.impl;

import com.cabservice.models.Location;
import com.cabservice.models.Trip;
import com.cabservice.models.User;
import com.cabservice.services.CoreDataService;
import com.cabservice.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    public String registerUser(String name, String mobileNumber, String email, String address,
                               CoreDataService coreDataService) {
        User user = new User(name, mobileNumber, email, address);
        coreDataService.addUser(user);
        return user.getUuid();
    }

    public String bookCab(String userId, Location currentLocation) {
        //


    }

    public List<Trip> fetchCompleteTripHistory(String userId, CoreDataService coreDataService) {
        return coreDataService.getUser(userId).getTripList();
    }

    void endTrip(String userId) {

    }
}