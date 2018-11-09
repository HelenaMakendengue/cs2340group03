package edu.gatech.cs2340.donationtracker;

/**
 * Enums for possible item categories
 */
public enum Category {
    Clothing ("Clothing"),
    Hat ("Hat"),
    Kitchen ("Kitchen"),
    Electronics ("Electronics"),
    Household ("Household"),
    Other ("Other");

    private final String representation;
    Category(String representation) {
        this.representation = representation;
    }

    /**
     * A getter for the category value
     * @return the string representation of the enum value
     */
    public String getRepresentation() {
        return representation;
    }
}
