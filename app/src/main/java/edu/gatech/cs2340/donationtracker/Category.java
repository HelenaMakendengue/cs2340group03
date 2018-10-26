package edu.gatech.cs2340.donationtracker;

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

    public String getRepresentation() {
        return representation;
    }
}
