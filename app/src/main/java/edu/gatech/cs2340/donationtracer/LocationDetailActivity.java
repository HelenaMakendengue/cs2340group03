package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LocationDetailActivity extends AppCompatActivity {

    String search = LoginActivity.username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail);
        Button seeInventoryBtn = (Button) findViewById(R.id.button_inventory);
        Button addItemBtn = (Button) findViewById(R.id.button_addItem);

        getIncomingIntent();

        // To be implemented -> get username somehow
        // RegistrationActivity.userDatabase.get(search).getAccountType() != AccountType.CUSTOMER
        if (true) {
            addItemBtn.setVisibility(View.VISIBLE);
            addItemBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(LocationDetailActivity.this, AddItemActivity.class));
                }
            });
        } else {
            addItemBtn.setVisibility(View.GONE);
        }
    }

    private void getIncomingIntent() {

            String name = getIntent().getStringExtra("location_name");
            String type = getIntent().getStringExtra("location_type");
            String longitude = getIntent().getStringExtra("location_longitude");
            String latitude = getIntent().getStringExtra("location_latitude");
            String address = getIntent().getStringExtra("location_address");
            String number = getIntent().getStringExtra("location_number");

            setWidget(name, type, longitude, latitude, address, number);
    }

    private void setWidget(String name, String type, String longitude, String latitude,
                                                            String address, String number) {

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
