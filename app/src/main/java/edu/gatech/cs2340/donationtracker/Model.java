package edu.gatech.cs2340.donationtracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private final Map<Location, ArrayList> locationDB = new HashMap<>();

    private static final Model instance = new Model();

    public static Model getInstance() {
        return instance;
    }

    public void addLocation(Location location) {
        locationDB.put(location, new ArrayList());
    }

// --Commented out by Inspection START (11/8/18, 5:18 PM):
    public void addItem(Location location, Item item) {
        ArrayList currentlist = locationDB.get(location); // returns the arraylist
        currentlist.add(item);
        locationDB.put(location, currentlist);
    }
// --Commented out by Inspection STOP (11/8/18, 5:18 PM)

    public Location findLocation(String locationTxt) {
        for (Location location: locationDB.keySet()) {
            if (location.getName().equals(locationTxt)) {
                return location;
            }
        }
        return null;
    }
}
