package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Location detail activity displays the details of a selected
 * location and allows connects to the activity that displays a location's
 * inventory as well as the add item activity.
 */
public class LocationDetailActivity extends AppCompatActivity {

    private String locationName;
    private String number;
    private String address;
    private String latitude;
    private String longitude;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail);
        Button seeInventoryBtn = findViewById(R.id.button_inventory);
        Button addItemBtn = findViewById(R.id.button_addItem);

        getIncomingIntent();
//        System.out.println("Location in LocationDetailActivity: " + locationName);

//        // programming button visibility
//        if (need to get account type == AccountType.CUSTOMER) {
//            addItemBtn.setVisibility(View.GONE);
//        } else {
//            addItemBtn.setVisibility(View.VISIBLE);
//        }

        addItemBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LocationDetailActivity.this, AddItemActivity.class);
            intent.putExtra("location_name", locationName);
            intent.putExtra("location_name", locationName);
            intent.putExtra("location_type",type);
            intent.putExtra("location_longitude",longitude);
            intent.putExtra("location_latitude", latitude);
            intent.putExtra("location_address", address);
            intent.putExtra("location_number", number);
            startActivity(intent);
        });

        seeInventoryBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LocationDetailActivity.this, ItemScroller.class);
            intent.putExtra("location_name", locationName);
            intent.putExtra("location_type",type);
            intent.putExtra("location_longitude",longitude);
            intent.putExtra("location_latitude", latitude);
            intent.putExtra("location_address", address);
            intent.putExtra("location_number", number);
            startActivity(intent);
        });
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

            setWidget(name, type, longitude, latitude, address, number);
    }

    private void setWidget(CharSequence name, CharSequence type, CharSequence longitude, CharSequence latitude,
                           CharSequence address, CharSequence number) {

        TextView loc_name = findViewById(R.id.location_name);
        loc_name.setText(name);

        TextView loc_type = findViewById(R.id.location_type);
        loc_type.setText(type);

        TextView loc_longitude = findViewById(R.id.location_longitude);
        loc_longitude.setText(longitude);

        TextView loc_latitude = findViewById(R.id.location_latitude);
        loc_latitude.setText(latitude);

        TextView loc_address = findViewById(R.id.location_address);
        loc_address.setText(address);

        TextView loc_number = findViewById(R.id.location_number);
        loc_number.setText(number);

    }

}
