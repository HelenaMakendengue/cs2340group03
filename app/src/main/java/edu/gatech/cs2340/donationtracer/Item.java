package edu.gatech.cs2340.donationtracer;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Item {

    private static ArrayList<Item> itemList = new ArrayList<>();

    private Timestamp timestamp;
    private Location location;
    private String shortDesc;
    private String fullDesc;
    private double dollarValue;
    private Category category;

    // --> Comments (optional)
    // --> Picture (optional)

    public Item (Timestamp timestamp, Location location, String shortDesc, String fullDesc, Double dollarValue, Category category) {
        this.timestamp = timestamp;
        this.location = location;
        this.shortDesc = shortDesc;
        this.fullDesc = fullDesc;
        this.dollarValue = dollarValue;
        this.category = category;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) { this.location = location; }

    public String getShortDesc() {
        return shortDesc;
    }
    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    public String getFullDesc() { return fullDesc; }
    public void setFullDesc(String fullDesc) { this.fullDesc = fullDesc; }

    public Double getDollarValue() {
        return dollarValue;
    }
    public void setDollarValue(double dollarValue) { this.dollarValue = dollarValue; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }
}
