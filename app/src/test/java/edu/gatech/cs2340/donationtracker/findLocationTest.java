package edu.gatech.cs2340.donationtracker;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Tests for the findLocation method in Model
 * Method is suppose to find a location from the location list based on the inputted location name
 * If present, location is returned
 * If not present, null is returned
 * Created by Mahima Chander on 11/08/18.
 */
@SuppressWarnings("JavaDoc")
public class findLocationTest {

    private Model testModel;
    private Location loc1;
    private Location loc2;
    private Location loc3;

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
    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void validLocation() {
        testModel.addLocation(loc1);
        testModel.addLocation(loc2);
        testModel.addLocation(loc3);

        String loc1_name = loc1.getName();

        assertEquals("Location is in Db; thus, but it is not returned ",loc1,
                testModel.findLocation(loc1_name));
    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void invalidLocation() {
        testModel.addLocation(loc1);
        testModel.addLocation(loc2);

        String loc3_name = loc3.getName();

        assertNull("Location is not in Db, but null is not returned: ", testModel.findLocation(loc3_name));
    }

    @Test
    public void nullLocation() {
        String loc1_name = loc1.getName();

        assertNull("The Db is empty, but null is not returned: ", testModel.findLocation(loc1_name));
    }

}
