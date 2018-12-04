package edu.gatech.cs2340.donationtracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * The DirectionActivity initiates the google map display screen,
 * as well as the pins representing selected location.
 */
public class DirectionActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String locationName;
    private String number;
    private String address;
    private String latitude;
    private String longitude;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        getIncomingIntent();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void getIncomingIntent() {

        String name = getIntent().getStringExtra("location_name");
        String type = getIntent().getStringExtra("location_type");
        String longitude = getIntent().getStringExtra("location_longitude");
        String latitude = getIntent().getStringExtra("location_latitude");
        String address = getIntent().getStringExtra("location_address");
        String number = getIntent().getStringExtra("location_number");
        this.locationName = name;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.number = number;

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
        if (this.latitude != null || this.longitude != null) {
            LatLng store = new LatLng(Double.parseDouble(this.latitude), Double.parseDouble(this.longitude));
            mMap.addMarker(new MarkerOptions().position(store).title("Location: " + this.locationName));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(store));
        }

    }

}
