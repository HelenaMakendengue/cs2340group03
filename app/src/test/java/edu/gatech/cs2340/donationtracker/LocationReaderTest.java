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

    private int locationCount = 0;

    @Test
    public void properLocationCount() {
        assertEquals(locationCount, 5);
    }
}