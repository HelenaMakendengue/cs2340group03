package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;


public class AddItemActivity extends AppCompatActivity {

    private DatabaseReference databaseItems;

    private String locationName;
    private String number;
    private String address;
    private String latitude;
    private String longitude;
    private String type;

    private Button back;
    private Button submit;
    private EditText title;
    private EditText description;
    private EditText value;
    private EditText comment;
    private Spinner category_spinner;

    private void addItem(Item item) {
        databaseItems.child(item.getLocation().getName()).push().setValue(item);

        //model.addItem(currentLocation, newItem);
        Intent intent = new Intent(AddItemActivity.this, LocationDetailActivity.class);
        intent.putExtra("location_name", locationName);
        intent.putExtra("location_type",type);
        intent.putExtra("location_longitude",longitude);
        intent.putExtra("location_latitude", latitude);
        intent.putExtra("location_address", address);
        intent.putExtra("location_number", number);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Database References
        databaseItems = FirebaseDatabase.getInstance().getReference("donations");

        initialize();

        getIncomingIntent();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(adapter);

        submit.setOnClickListener(v -> {
            String locationTxt = locationName;
            String shortDesc = title.getText().toString().trim();
            String fullDesc = description.getText().toString().trim();
            Double dollarValue = Double.parseDouble(value.getText().toString());
            Model model = Model.getInstance();
            Location currentLocation = model.findLocation(locationTxt);
            String timestamp = new Timestamp(System.currentTimeMillis()).toString();

            String id = databaseItems.push().getKey();

            Item newItem = new Item(timestamp, currentLocation, shortDesc,
                    fullDesc, dollarValue, (Category) category_spinner.getSelectedItem());
            addItem(newItem);
        });

        back.setOnClickListener(v -> {
            startActivity(new Intent(AddItemActivity.this, LocationDetailActivity.class));
            Intent intent = new Intent(AddItemActivity.this, LocationDetailActivity.class);
            intent.putExtra("location_name", locationName);
            intent.putExtra("location_type",type);
            intent.putExtra("location_longitude",longitude);
            intent.putExtra("location_latitude", latitude);
            intent.putExtra("location_address", address);
            intent.putExtra("location_number", number);
            startActivity(intent);

        });
    }

    private void initialize() {
        back = findViewById(R.id.button_cancel);
        submit = findViewById(R.id.button_add);
        title = findViewById(R.id.editText_title);
        description = findViewById(R.id.editText_description);
        value = findViewById(R.id.editText_value);
        comment = findViewById(R.id.editText_comment);
        category_spinner = findViewById(R.id.spinner_category);
    }

    private void getIncomingIntent() {
        String type = getIntent().getStringExtra("location_type");
        String longitude = getIntent().getStringExtra("location_longitude");
        String latitude = getIntent().getStringExtra("location_latitude");
        String address = getIntent().getStringExtra("location_address");
        String number = getIntent().getStringExtra("location_number");
        this.locationName = getIntent().getStringExtra("location_name");
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.number = number;
    }
}