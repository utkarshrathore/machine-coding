package com.cabservice.models;

import java.util.Date;
import java.util.UUID;

public class Trip {
    private UUID id;
    private Date startTime;
    private Date endTime;
    private Location startLocation;
    private Location endLocation;
    private Driver driverAssigned;

    public Trip(Date startTime, Date endTime, Location startLocation, Location endLocation, Driver driverAssigned) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.driverAssigned = driverAssigned;
    }

    public UUID getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public Driver getDriverAssigned() {
        return driverAssigned;
    }

    public void setDriverAssigned(Driver driverAssigned) {
        this.driverAssigned = driverAssigned;
    }
}
