package edu.gatech.cs2340.donationtracker;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

/**
 * The MapActivity initiates the google map display screen,
 * as well as the pins representing each locations in the
 * database
 */
public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ArrayList<Location> locationLst = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
       // ArrayList<Location> locationLst = new ArrayList<>();


        // Example: Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        FirebaseDatabase.getInstance().getReference("locations").addValueEventListener(new ValueEventListener() {
            //public ArrayList<Item> itemSubList;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    // Update my client activity list with tbe one new item received from firebase.
                    Location location = d.getValue(Location.class);
                    //locationLst.add(d.getValue(Location.class));
                    LatLng latLng = new LatLng(Double.parseDouble(Objects.requireNonNull(location).getLatitude()),
                            Double.parseDouble(location.getLongitude()));
                    mMap.addMarker(new MarkerOptions().position(latLng).title(location.getName()).snippet("Phone: " + location.getNumber()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });
/*

        */
    }
}
