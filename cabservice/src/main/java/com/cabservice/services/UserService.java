package com.cabservice.services;

import com.cabservice.models.Location;
import com.cabservice.models.Trip;

import java.util.List;

public interface UserService {
    String registerUser(String name, String mobileNumber, String email, String address,
                        CoreDataService coreDataService);
    String bookCab(String userId, Location currentLocation);
    List<Trip> fetchCompleteTripHistory(String userId);
    void endTrip(String userId);
}
