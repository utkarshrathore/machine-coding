package com.cabservice.utils;

import com.cabservice.models.Location;

public class LocationUtils {
    public static double getDistance(Location l1, Location l2) {
        double xdiff = l1.getxCoordinate() - l2.getxCoordinate();
        double ydiff = l1.getyCoordinate() - l2.getyCoordinate();
        return Math.sqrt(xdiff*xdiff+ydiff*ydiff);
    }
}