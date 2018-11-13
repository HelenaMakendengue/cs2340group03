package edu.gatech.cs2340.donationtracker;

import java.util.ArrayList;
import java.util.List;

class Search {
    private final Iterable<Item> master;

    public Search(Iterable<Item> master) {
        this.master = master;
    }

    /**
     * A method to search for items by name
     *
     * @param term the search term input by the user
     * @param location the location, if applicable, the user wants to search at
     * @return a list of items that fit the search criteria
     */
    public List<Item> searchByName(String term, String location) {
        List<Item> searched = new ArrayList<>();

        if ("".equals(term) || (term == null)) {
            return searched;
        }

        if (location == null) {
            for (Item item : master) {
                if (item.getShortDesc().toLowerCase().contains(term.toLowerCase())) {
                    searched.add(item);
                }
            }
        } else {
            for (Item item : master) {
                if (item.getShortDesc().toLowerCase().contains(term.toLowerCase()) && item.getLocation().getName().equals(location)) {
                    searched.add(item);
                }
            }
        }

        return searched;
    }

    /**
     * A method to search for items by category
     *
     * @param category the category of items the user is searching for
     * @param location the location, if applicable, the user wants to search at
     * @return a list of items that fit the search criteria
     */
    public List<Item> searchByCategory(Category category, String location) {
        List<Item> searched = new ArrayList<>();

        if (location == null) {
            for (Item item : master) {
                if (item.getCategory().equals(category)) {
                    searched.add(item);
                }
            }
        } else {
            for (Item item : master) {
                if (item.getCategory().equals(category) && item.getLocation().getName().equals(location)) {
                    searched.add(item);
                }
            }
        }

        return searched;
    }
}
