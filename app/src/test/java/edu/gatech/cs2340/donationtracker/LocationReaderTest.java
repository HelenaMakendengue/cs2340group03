package edu.gatech.cs2340.donationtracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the LocationReader() method in Model
 * Method is suppose to find a location from the location list based on the inputted location name
 * If present, location is returned
 * If not present, null is returned
 * Created by Helena Makendengue on 11/08/18.
 */
public class LocationReaderTest {

    private Model testModel;

    private Location locationOne = new Location("1", "AFD Station",
            "4,33.75416", "-84.37742",
            "309 EDGEWOOD AVE SE, Atlanta, GA 30332", LocationType.DROP_OFF_ONLY,
            "(404) 555 - 3456",
            "www.afd04.atl.ga");
    private Location locationTwo = new Location("2", "BOYS & GILRS CLUB W.W. WOOLFOLK",
            "33.73182", "-84.43971",
            "1642 RICHLAND RD, Atlanta, GA 30332", LocationType.STORE,
            "(404) 555 - 1234",
            "www.bgc.wool.ga");
    private Location locationThree = new Location("3",
            "PATHWAY UPPER ROOM CHRISTIAN MINISTRIES", "33.70866",
            "-84.41853", "683 SYLVAN RD, Atlanta, GA 30332",
            LocationType.WAREHOUSE, "(404) 555 - 5432",
            "www.pathways.org");
    private Location locationFour = new Location("4", "PAVILION OF HOPE INC",
            "33.80129", "-84.25537",
            "3558 EAST PONCE DE LEON AVE, SCOTTDALE, GA 30079",
            LocationType.WAREHOUSE, "(404) 555 - 8765",
            "www.pathways.org");
    private Location locationFive = new Location("5", "D&D CONVENIENCE STORE",
            "33.71747", "-84.2521",
            "2426 COLUMBIA DRIVE, DECATUR, GA 30034", LocationType.DROP_OFF_ONLY,
            "(404) 555 - 9876",
            "www.ddconv.com");
    private Location locationSix = new Location("6", "KEEP NORTH FULTON BEAUTIFUL",
            "33.96921", "-84.3688",
            "470 MORGAN FALLS RD, Sandy Springs, GA 30302", LocationType.STORE,
            "(770) 555 - 7321",
            "www.knfb.org");

    @Before
    public void setUp() {
        testModel = new Model();
        Model.LocationReaderModel();
    }

    @Test
    public void properLocationCount() {
        assertEquals(testModel.getModelDB().size(), 6);
    }

    @Test
    public void compareAttributes() {
        assertEquals(locationOne.toString(), testModel.getModelDB().get(0).toString());
        assertEquals(locationTwo.toString(), testModel.getModelDB().get(1).toString());
        assertEquals(locationThree.toString(), testModel.getModelDB().get(2).toString());
        assertEquals(locationFour.toString(), testModel.getModelDB().get(3).toString());
        assertEquals(locationFive.toString(), testModel.getModelDB().get(4).toString());
        assertEquals(locationSix.toString(), testModel.getModelDB().get(5).toString());
    }
}