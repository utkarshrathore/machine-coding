package com.cabservice.services;

import com.cabservice.models.Location;

public interface LocationService {
    void updateCabLocation(String cabId, Location newLocation, CoreDataService coreDataService);
}
