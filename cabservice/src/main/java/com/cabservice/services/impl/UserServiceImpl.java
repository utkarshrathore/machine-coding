package com.cabservice.services.impl;

import com.cabservice.models.Cab;
import com.cabservice.models.Location;
import com.cabservice.models.Trip;
import com.cabservice.models.User;
import com.cabservice.services.CoreDataService;
import com.cabservice.services.UserService;
import com.cabservice.utils.Constants;
import com.cabservice.utils.LocationUtils;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    public String registerUser(String name, String mobileNumber, String email, String address,
                               CoreDataService coreDataService) {
        User user = new User(name, mobileNumber, email, address);
        coreDataService.addUser(user);
        return user.getUuid();
    }

    private String getMinDistanceCab(Location userLocation, CoreDataService coreDataService) {
        double minDistance = Integer.MAX_VALUE;
        Cab closestCab=null;
        Map<String, Cab> cabMap = coreDataService.getCabMap();
        for(Cab c : cabMap.values()) {
           Location cabLocation =  c.getCurrentLocation();
           double distance = LocationUtils.getDistance(cabLocation, userLocation);
           if(distance<minDistance) {
               minDistance=distance;
               closestCab=c;
           }
        }
        if(closestCab==null || minDistance>= Constants.MAX_DISTANCE_TO_PICKUP_RIDER_IN_KM) {
            return null;
        }

        return closestCab.getUuid();
    }

    public String bookCab(String userId, Location userLocation, CoreDataService coreDataService) {
        String cabId = getMinDistanceCab(userLocation, coreDataService);
        User user = co







    }

    public List<Trip> fetchCompleteTripHistory(String userId, CoreDataService coreDataService) {
        return coreDataService.getUser(userId).getTripList();
    }

    public void endTrip(String userId, String tripId) {


    }
}