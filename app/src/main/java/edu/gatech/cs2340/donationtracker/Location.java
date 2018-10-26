package edu.gatech.cs2340.donationtracker;

public class Location {

    String key;
    String name;
    String latitude;
    String longitude;
    String address;
    LocationType type;
    String phoneNumber;
    String website;

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

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocationType getType() {
        return type;
    }
    public void setType(LocationType type) { this.type = type; }

    public String getNumber() {
        return phoneNumber;
    }
    public void setNumber(String number) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    //for debugging purposes
    public String toString() {

        return (key + " " + name + " " + latitude + " " + longitude + " " + address + " " + type + " " + phoneNumber + " " + website);
    }
}