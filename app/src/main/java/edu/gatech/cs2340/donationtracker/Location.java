package edu.gatech.cs2340.donationtracker;


/**
 * Represents a location object.
 */
public class Location {

    private String key;
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private LocationType type;
    private String phoneNumber;
    private String website;

//    public Location() {};

    /**
     * This method creates a location with the given parameters
     *
     * @param key the key of the location
     * @param name the name of the location
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     * @param address the address of the location
     * @param type the type of location
     * @param phoneNumber the phone number of the location
     * @param website the website of the location
     */
    public Location(String key, String name, String latitude, String longitude, String address,
                    LocationType type, String phoneNumber, String website) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    /**
     * This method gets and returns the key of each location
     *
     * @return key the key for the location
     */
    public String getKey() {
        return key;
    }

    /**
     * This method sets the key of each location
     *
     * @param key the key of each location
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * This method gets and returns the name of each location
     *
     * @return name the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of each location
     *
     * @param name the name of each location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets and returns the latitude
     * of each location
     *
     * @return latitude the latitude of the location
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method sets the latitude of each location
     *
     * @param latitude the latitude of each location
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * This method gets and returns the longitude
     * of each location
     *
     * @return longitude the longitude of the location
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method sets the longitude of each location
     *
     * @param longitude the longitude of each location
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * This method gets and returns the address
     * of each location
     *
     * @return address the address of the location
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets the address of each location
     *
     * @param address the address of each location
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method gets and returns the location type
     * of each location
     *
     * @return type the type of the location
     */
    public LocationType getType() {
        return type;
    }

    /**
     * This method sets the location type of each location
     *
     * @param type the location type of each location
     */
    public void setType(LocationType type) { this.type = type; }

    /**
     * This method gets and returns the phone
     * number of each location
     *
     * @return phoneNumber the phone number of the location
     */
    public String getNumber() {
        return phoneNumber;
    }

    /**
     * This method sets the phone number of each location
     *
     * @param phoneNumber the phone number of each location
     */
    public void setNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method gets and returns the website
     * for each location
     *
     * @return website the website for the location
     */
    public String getWebsite() {
        return website;
    }

    /**
     * This method sets the website for each location
     *
     * @param website the website for each location
     */
    public void setWebsite(String website) {
        this.website = website;
    }

//    //for debugging purposes
//    public String toString() {
//
//        return (key + " " + name + " " + latitude + " " + longitude + " " + address + " " + type + " " + phoneNumber + " " + website);
//    }
}