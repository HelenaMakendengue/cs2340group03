package edu.gatech.cs2340.donationtracker;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Regulates the object contract and how they are stored.
 */
public class Model {

    private final Map<Location, ArrayList> locationDB = new HashMap<>();
    private static final List<Location> modelDB = new ArrayList<>();
    private static List<User> userDB = new ArrayList<>();

    private static final Model instance = new Model();

    /**
     * Getter for the model
     * @return the instance for model
     */
    public static Model getInstance() {
        return instance;
    }

    /**
     * Getter for locationDB
     * @return the locationDB
     */
    public Map<Location, ArrayList> getLocationDB() {
        return locationDB;
    }
    /**
     * Getter for userDB
     * @return the locationDB
     */
    public List<User> getUserDB() {
        return userDB;
    }
    /**
     * Add a new location.
     * @param location the location object to be added
     */
    public void addLocation(Location location) {
        locationDB.put(location, new ArrayList());
    }

    /**
     * Add a new item to a selected location
     * @param item the item to be added
     * @param location the location where the item is added to
     * @return boolean true if item is valid
     */
    public boolean addItem(Location location, Item item) {
        if ((item.getShortDesc().isEmpty()) || (item.getCategory() == null)
                || (item.getLocation() == null)) {
            return false;
        }
        ArrayList currentlist = locationDB.get(location); // returns the arraylist
        if (currentlist == null) {
            currentlist = new ArrayList();
        }
        currentlist.add(item);
        locationDB.put(location, currentlist);
        return true;
    }

    /**
     * Find a location matching the text input
     * @param locationTxt the text entered in the search bar
     * @return the location if search result matches, else returns null
     */
    public Location findLocation(String locationTxt) {
        for (Location location: locationDB.keySet()) {
            if (location.getName().equals(locationTxt)) {
                return location;
            }
        }
        return null;
    }

    public String registerCustomer(String username, String password, String email) {
        if ("".equals(username) || "".equals(password) || "".equals(email)) {
            return "One or more empty field(s)";
        } else if (password.length() < 6) {
            return "Password too short.";
        } else if (!email.contains("@")) {
           return "The email you entered is not a email.";
        } else {
            for (User user : userDB) {
                if(username.equals(user.getLoginName())) {
                    return "Username already taken";
                }
            }
            userDB.add(new User(username, password, true, email, AccountType.CUSTOMER));
            return "Customer created successfully.";
        }
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


    /**
     * A method to get a list of locations in the model.
     * @return returns a list of all locations
     */
    public static List<Location> getModelDB() {
        return modelDB;
    }
}