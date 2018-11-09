package edu.gatech.cs2340.donationtracker;




import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for the searchByName method in Search class
 * Method is suppose to create a list of items that fit the search criteria
 * Created by Matthew Davis Williams on 11/08/18.
 */
public class SearchTest {

    Location location1;
    Location location2;
    private Location location3;

    Item shoe;
    Item lamp;
    Item waterBottle;

    Search search;

    @Before
    public void setUp() {
        ArrayList<Item> master = new ArrayList<>();

        location1 = new Location(null, "Howie", null, null, null, null, null, null);
        location2 = new Location(null, "CULC", null, null, null, null, null, null);
        location3 = new Location(null, "Garbage Can", null, null, null, null, null, null);

        shoe = new Item(null, location1, "Shoelace", null, 1.0, Category.Clothing);
        lamp = new Item(null, location3, "Lamp", null, 1.0, Category.Electronics);
        waterBottle = new Item(null, location3, "Water bottle", null, 1.0, Category.Kitchen);

        master.add(shoe);
        master.add(lamp);
        master.add(waterBottle);

        search = new Search(master);
    }

    @Test
    public void searchStringNullNoLocation() {
        List<Item> searched;
        searched = search.searchByName(null, null);
        assertEquals(0, searched.size());
    }

    @Test
    public void searchStringNullWithLocation() {
        List<Item> searched;
        searched = search.searchByName(null, location1.getName());
        assertEquals(0, searched.size());
    }

    @Test
    public void searchStringOneResultNoLocation() {
        List<Item> searched;
        List<Item> compare = new ArrayList<>();
        compare.add(waterBottle);
        searched = search.searchByName("Water bottle", null);
        assertEquals(1, searched.size());
        assertEquals(compare, searched);

    }

    @Test
    public void searchStringMultipleResultsNoLocation() {
        List<Item> searched;
        ArrayList<Item> compare = new ArrayList<>();
        compare.add(shoe);
        compare.add(lamp);
        searched = search.searchByName("la", null);
        assertEquals(2, searched.size());
        assertEquals(compare, searched);
    }

    @Test
    public void searchStringNoResultsNoLocation() {
        List<Item> searched;
        ArrayList<Item> compare = new ArrayList<>();
        searched = search.searchByName("garbage", null);
        assertEquals(0, searched.size());
        assertEquals(compare, searched);
    }

    @Test
    public void searchStringOneResultWithLocation() {
        List<Item> searched;
        ArrayList<Item> compare = new ArrayList<>();
        compare.add(shoe);
        searched = search.searchByName("shoe", location1.getName());
        assertEquals(1, searched.size());
        assertEquals(compare, searched);

    }

    @Test
    public void searchStringLocationRestrictsResults() {
        List<Item> searched;
        ArrayList<Item> compare = new ArrayList<>();
        compare.add(lamp);
        searched = search.searchByName("la", location3.getName());
        assertEquals(1, searched.size());
        assertEquals(compare, searched);
    }

    @Test
    public void searchStringAllResultsCutByLocation() {
        List<Item> searched;
        ArrayList<Item> compare = new ArrayList<>();
        searched = search.searchByName("shoelace", location3.getName());
        assertEquals(0, searched.size());
        assertEquals(compare, searched);
    }

    @Test
    public void searchStringMultipleResultsWithLocation() {
        List<Item> searched;
        ArrayList<Item> compare = new ArrayList<>();
        compare.add(lamp);
        compare.add(waterBottle);
        searched = search.searchByName("l", location3.getName());
        assertEquals(2, searched.size());
        assertEquals(compare, searched);
    }
}