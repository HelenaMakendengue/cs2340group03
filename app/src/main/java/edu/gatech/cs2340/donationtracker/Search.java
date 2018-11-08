package edu.gatech.cs2340.donationtracker;

import java.util.ArrayList;
import java.util.List;

public class Search {
    Iterable<Item> master;

    public Search(Iterable<Item> master) {
        this.master = master;
    }

    public List<Item> searchByName(String term, String location) {
        List<Item> searched = new ArrayList<>();

        if ("".equals(term)) {
            return searched;
        }

        if (location == null) {
            for (Item item : master) {
                if (item.getShortDesc().toLowerCase().contains(term)) {
                    searched.add(item);
                }
            }
        } else {
            for (Item item : master) {
                if (item.getShortDesc().toLowerCase().contains(term) && item.getLocation().getName().equals(location)) {
                    searched.add(item);
                }
            }
        }

        return searched;
    }

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
