package edu.gatech.cs2340.donationtracer;

import java.io.*;
import java.util.HashMap;

public class LocationReader {
    private static HashMap<Integer, Location> db = new HashMap<>();

    public static HashMap<Integer, Location> getDb() {
        return db;
    }

    public static void execute() throws Exception {

        File file = new File("LocationData.txt");
        String filePath = file.getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        //Marks the start of the CSV file
        br.mark(1000);

        //Reads past first line to prevent KEY location from being made...
        br.readLine();

        String text;

        while ((text = br.readLine()) != null) {

            //for debugging purposes
            System.out.println(text);

            String[] ar = text.split(",");

            for (int i = 0; i < ar.length; i++) {
                ar[i] = ar[i].trim();

                //for debugging purposes
                System.out.println(ar[i]);
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

            //example of creating a new Location
            Location example = new Location(ar[0], ar[1], ar[2], ar[3], address, locationType, ar[9], ar[10]);
            //storing example to our database
            //generate hashcode with ar[0] and ar[1] field
            db.put(ar[9].hashCode(), example);
            //for debugging purposes
            System.out.println(example);
        }

        //returns to the start of the CSV file
        br.reset();
    }
    public static void main(String[] args) throws Exception {
        execute();
        System.out.print(db.keySet());
    }

}