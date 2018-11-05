package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    Model model = Model.getInstance();

    public static String TAG = "DONATION_TRACKER";

    DatabaseReference databaseLocations;
    private HashSet<Location> locationSet;
    private static HashMap<Integer, Location> db = new HashMap<>();
    public static HashMap<Integer, Location> getDb() {
        return db;
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationSet = getLoactionSet();
        //Database References
        databaseLocations = FirebaseDatabase.getInstance().getReference("locations");

        //Button References
        Button logoutBtn = findViewById(R.id.button_logout);
        Button mapBtn = findViewById(R.id.button_mapView);

        //Methods
        LocationReader(locationSet);

        //Recycler Stuff
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(getDb());
        recyclerView.setAdapter(adapter);


        //Button Event Listeners
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapActivity.class));
            }
        });
    }

    // reads from firebase and populates the locationSet.
    // Prevents locationReader from adding duplicates.
    public HashSet<Location> getLoactionSet() {

        DatabaseReference databaseLocations = FirebaseDatabase.getInstance().getReference("locations");

        Query query = databaseLocations;
        HashSet<Location> mySet = new HashSet<>();

        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // reads locations from firebase and drops markers (location name & number) on map
                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    Location location = d.getValue(Location.class);
                    mySet.add(location);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });
        return mySet;
    }

    private void LocationReader(HashSet set) {

        try {

            //Open a stream on the raw file
            InputStream inputStream = getResources().openRawResource(R.raw.locationdata);

            //From here we probably should call a model method and pass the InputStream
            //Wrap it in a BufferedReader so that we get the readLine() method
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));


            //Marks the start of the CSV file
            br.mark(1000);

            //Reads past first line to prevent KEY location from being made...
            br.readLine();
            String text;

            while ((text = br.readLine()) != null) {

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

                String id = databaseLocations.push().getKey();

                //new Location is created
                Location newLocation = new Location(ar[0], ar[1], ar[2], ar[3], address, locationType, ar[9], ar[10]);
                if (!set.contains(newLocation)) {
                    databaseLocations.child(id).setValue(newLocation);

                    //storing new Location to our database
                    //generate hashcode with ar[0] and ar[1] field
                    db.put(ar[9].hashCode(), newLocation);
                    model.addLocation(newLocation);

                    System.out.println(newLocation);
                }
            }
            br.close();
        } catch (IOException e) {
            Log.e(MainActivity.TAG, "error reading assets", e);
        }
    }
}