package edu.gatech.cs2340.donationtracker;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;

public class Model {

    private Context context;

    public Model() { }

    public Model(Context current) {
        this.context = current;
    }

    Map<Location, ArrayList> locationDB = new HashMap<>();

    public static final Model instance = new Model();


    public static Model getInstance() {
        return instance;
    }

    public void addLocation(Location location) {
        locationDB.put(location, new ArrayList());
    }

    public void addItem(Location location, Item item) {
        ArrayList currentlist = locationDB.get(location); // returns the arraylist
        currentlist.add(item);
        locationDB.put(location, currentlist);
    }

    public Location findLocation(String locationTxt) {
        for (Location location: locationDB.keySet()) {
            if (location.getName().equals(locationTxt)) {
                return location;
            }
        }
        return null;
    }

    private void LocationReaderModel() {

        try {

            //Open a stream on the raw file
            InputStream inputStream = context.getResources().openRawResource(R.raw.locationdata);

            //From here we probably should call a model method and pass the InputStream
            //Wrap it in a BufferedReader so that we get the readLine() method
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            //Marks the start of the CSV file
            br.mark(1000);

            //Reads past first line to prevent KEY location from being made...
            br.readLine();

            String text = br.readLine();

            while (text != null) {

                String[] ar = text.split(",");

                for (int i = 0; i < ar.length; i++) {
                    ar[i] = ar[i].trim();
                }

                String address = ar[4] + ", " + ar[5] + ", " + ar[6] + " " + ar[7];
                LocationType locationType;

                if (ar[8].equals("Store")) {
                    locationType = LocationType.STORE;
                } else if (ar[8].equals("Drop Off")) {
                    locationType = LocationType.DROP_OFF_ONLY;
                } else {
                    locationType = LocationType.WAREHOUSE;
                }

                //Firebase Stuff
                //String id = databaseLocations.push().getKey();

                //new Location is created
                Location newLocation = new Location(ar[0], ar[1], ar[2], ar[3], address, locationType, ar[9], ar[10]);

                //Firebase Stuff
                //databaseLocations.child(id).setValue(newLocation);

                //storing new Location to our database
                //generate hashcode with ar[0] and ar[1] field
                MainActivity.getDb().put(ar[9].hashCode(), newLocation);

                //JUnit written for this method
                addLocation(newLocation);

                System.out.println(newLocation);
                text = br.readLine();
            }

            br.close();

        } catch (IOException e) {
            Log.e(MainActivity.TAG, "error reading assets", e);
        }
    }
}