package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "DONATION_TRACKER";

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
        Button logoutBtn = findViewById(R.id.button_logout);

        LocationReader();

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(getDb());
        recyclerView.setAdapter(adapter);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            }
        });
    }

    private void LocationReader() {

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

                //new Location is created
                Location newLocation = new Location(ar[0], ar[1], ar[2], ar[3], address, locationType, ar[9], ar[10]);

                //storing new Location to our database
                //generate hashcode with ar[0] and ar[1] field
                db.put(ar[9].hashCode(), newLocation);

                System.out.println(newLocation);
            }

            br.close();

        } catch (IOException e) {
            Log.e(MainActivity.TAG, "error reading assets", e);
        }
    }
}
