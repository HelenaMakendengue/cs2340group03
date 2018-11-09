package edu.gatech.cs2340.donationtracker;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;

public class Model {

    private Context context;

    public Model() { }

    private Map<Location, ArrayList> locationDB = new HashMap<>();
    private static ArrayList<Location> modelDB = new ArrayList<>();

    public static final Model instance = new Model();


    public static Model getInstance() {
        return instance;
    }

    public void addLocation(Location location) {
        locationDB.put(location, new ArrayList());
    }

    public void addItem(Location location, Item item) {
        ArrayList currentlist = locationDB.get(location); // returns the arraylist
        currentlist.add(item);
        locationDB.put(location, currentlist);
    }

    public Location findLocation(String locationTxt) {
        for (Location location: locationDB.keySet()) {
            if (location.getName().equals(locationTxt)) {
                return location;
            }
        }
        return null;
    }

    public static void LocationReaderModel() {
        modelDB.add(new Location("1", "AFD Station", "4,33.75416", "-84.37742",
                "309 EDGEWOOD AVE SE, Atlanta, GA 30332", LocationType.DROP_OFF_ONLY, "(404) 555 - 3456",
                "www.afd04.atl.ga"));
        modelDB.add(new Location("2", "BOYS & GILRS CLUB W.W. WOOLFOLK", "33.73182", "-84.43971",
                "1642 RICHLAND RD, Atlanta, GA 30332", LocationType.STORE, "(404) 555 - 1234",
                "www.bgc.wool.ga"));
        modelDB.add(new Location("3", "PATHWAY UPPER ROOM CHRISTIAN MINISTRIES", "33.70866", "-84.41853",
                "683 SYLVAN RD, Atlanta, GA 30332", LocationType.WAREHOUSE, "(404) 555 - 5432",
                "www.pathways.org"));
        modelDB.add(new Location("4", "PAVILION OF HOPE INC", "33.80129", "-84.25537",
                "3558 EAST PONCE DE LEON AVE, SCOTTDALE, GA 30079", LocationType.WAREHOUSE, "(404) 555 - 8765",
                "www.pathways.org"));
        modelDB.add(new Location("5", "D&D CONVENIENCE STORE", "33.71747", "-84.2521",
                "2426 COLUMBIA DRIVE, DECATUR, GA 30034", LocationType.DROP_OFF_ONLY, "(404) 555 - 9876",
                "www.ddconv.com"));
        modelDB.add(new Location("6", "KEEP NORTH FULTON BEAUTIFUL", "33.96921", "-84.3688",
                "470 MORGAN FALLS RD, Sandy Springs, GA 30302", LocationType.STORE, "(770) 555 - 7321",
                "www.knfb.org"));
    }

    public static ArrayList<Location> getModelDB() {
        return modelDB;
    }
}