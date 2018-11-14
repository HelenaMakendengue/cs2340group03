package edu.gatech.cs2340.donationtracker;

import org.junit.Before;
import org.junit.Test;
import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the addItem method in Model
 * Method is suppose to add the passed in item to the location based on the inputted location object
 * If successful, return true
 * If not, False is returned. There will not be a new item in the firebase database
 * Created by Le-En Huang on 11/08/18.
 */
public class addItemTest {

    private Model testModel;
    private Location loc1;
    private Location loc2;
    private Location loc3;

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    @SuppressWarnings("JavaDoc")
    @Before
    public void setUp() {
        testModel = new Model();
        loc1 = new Location("1", "location1", "0001",
                "1000", "350 Ferst", LocationType.DROP_OFF_ONLY,
                "(954)835-9243", "location1.org");
        loc2 = new Location("2", "location2", "0002",
                "2000", "Howell Mill Rd", LocationType.STORE,
                "(754)924-0193", "location2.org");
        loc3 = new Location("3", "location3", "0003",
                "3000", "Peachtree St", LocationType.WAREHOUSE,
                "(455)194-2946", "location3.org");

        item1 = new Item(new Timestamp(System.currentTimeMillis()).toString(),
                loc1, "Winter Coat", "A burgendy female coat",
                30.9, Category.Clothing, "");
        item2 = new Item(new Timestamp(System.currentTimeMillis()).toString(),
                null, "Old Hat", "A grey hat",
                10.0, Category.Hat, ""); // no location
        item3 = new Item(new Timestamp(System.currentTimeMillis()).toString(),
                loc2, "", "Pots and pans",
                35.7, Category.Kitchen, ""); // no title
        item4 = new Item(new Timestamp(System.currentTimeMillis()).toString(),
                loc3, "Container", "Pots and pans",
                35.7, null, ""); // no category
    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void validItem() {
        testModel.addItem(loc1, item1);
//        testModel.addItem(loc2, item2);
//        testModel.addItem(loc3, item3);

        assertEquals("Winter Coat is a valid item",
                true, testModel.addItem(loc1, item1));
    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void invalidItemLocation() {
        testModel.addItem(loc2, item2);

        assertEquals("item missing param: location", false, testModel.addItem(loc2, item2));
    }

    @Test
    public void invalidItemShort() {
        testModel.addItem(loc3, item3);
        assertEquals("item missing param: shortDescription", false,
                testModel.addItem(loc3, item3));
    }

    @Test
    public void invalidItemCategory() {
        testModel.addItem(loc2, item4);
        assertEquals("item missing param: shortDescription", false,
                testModel.addItem(loc2, item4));
    }
}