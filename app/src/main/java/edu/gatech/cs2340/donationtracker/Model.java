package edu.gatech.cs2340.donationtracker;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {

    HashMap<Location, ArrayList> locationDB = new HashMap<>();

    public static final Model instance = new Model();

    public static Model getInstance() {
        return instance;
    }

    public void addLocation(Location location) {
        locationDB.put(location, new ArrayList());
    }

    public void addItem(Location location, Item item) {
        ArrayList currentlst = locationDB.get(location); // returns the arraylist
        currentlst.add(item);
        locationDB.put(location, currentlst);
    }

    public Location findLocation(String locationTxt) {
        for (Location location: locationDB.keySet()) {
            if (location.getName().equals(locationTxt)) {
                return location;
            }
        }
        return null;
    }
}
