package com.cabservice.services.impl;

import com.cabservice.models.Location;
import com.cabservice.services.CoreDataService;
import com.cabservice.services.LocationService;

public class LocationServiceImpl implements LocationService {
    public void updateCabLocation(String cabId, Location newLocation, CoreDataService coreDataService) {
        coreDataService.getCab(cabId).setCurrentLocation(newLocation);
    }
}