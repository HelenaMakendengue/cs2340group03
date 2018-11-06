package edu.gatech.cs2340.donationtracker;

import java.util.ArrayList;

public class Item {

    private static ArrayList<Item> itemList = new ArrayList<>();

    private String timestamp;
    private Location location;
    private String shortDesc;
    private String fullDesc;
    private double dollarValue;
    private Category category;

    public Item (String timestamp, Location location, String shortDesc, String fullDesc, Double dollarValue, Category category) {
        this.timestamp = timestamp;
        this.location = location;
        this.shortDesc = shortDesc;
        this.fullDesc = fullDesc;
        this.dollarValue = dollarValue;
        this.category = category;
    }

    public Item() {}

    /**
     * This method gets and returns the timestamp for
     * the item's creation.
     *
     * @return the timestamp for the item's creation.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * This method sets the timestamp for the item's
     * creation.
     *
     * @param timestamp a time in which the item was created
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * The method gets and returns the location
     * for this item.
     *
     * @return the location at which the item is available
     */
    public Location getLocation() {
        return location;
    }

    /**
     * This method sets the location for the item.
     *
     * @param location a location at which the item
     *                 is available
     */
    public void setLocation(Location location) { this.location = location; }

    /**
     * This method gets and returns the short
     * description about the item.
     *
     * @return the shortDesc about the item
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * This method sets the short description about an item
     *
     * @param shortDesc a short description about an item
     */
    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    /**
     * This method gets and returns a full description
     * about the item.
     *
     * @return the fullDesc about the item
     */
    public String getFullDesc() {
        return fullDesc;
    }

    /**
     * This method sets the full description about
     * an item.
     *
     * @param fullDesc a full description about an item
     */
    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    /**
     * This method gets and returns the dollar
     * value of the item.
     *
     * @return dollarValue the dollar value of the item
     */
    public Double getDollarValue() {
        return dollarValue;
    }

    /**
     * This method returns sets the dollar value of the item
     *
     * @param dollarValue a dollar value for the item
     */
    public void setDollarValue(double dollarValue) {
        this.dollarValue = dollarValue;
    }

    /**
     * This method gets and returns the category the item
     * falls under
     *
     * @return category the category that an item falls under
     */
    public Category getCategory() {
        return category;
    }

    /**
     * This method sets the category that the item falls under
     *
     * @param category a category that the item falls under
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * This method returns a list of store items
     *
     * @return itemList
     */
    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * This method represent the item in the form
     * of a String using the short description
     *
     * @return shortDesc the short description of an item
     */
    @Override
    public String toString() {
        return shortDesc;
    }
}