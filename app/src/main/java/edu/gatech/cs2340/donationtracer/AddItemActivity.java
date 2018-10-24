package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Timestamp;
import java.text.DateFormat;


public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button back = (Button) findViewById(R.id.button);
        Button submit = (Button) findViewById(R.id.button2);
        EditText location = (EditText) findViewById(R.id.locationtext);
        EditText title = (EditText) findViewById(R.id.text1);
        EditText description = (EditText) findViewById(R.id.text2);
        EditText value = (EditText) findViewById(R.id.dollar);
        EditText comment = (EditText) findViewById(R.id.text4);
        Spinner category_spinner = (Spinner) findViewById(R.id.spinner3);

        String locationTxt = location.toString().trim().toLowerCase();
        String shortDesc = title.toString().trim();
        String fullDesc = description.toString().trim();
        Double dollarValue = Double.parseDouble(value.toString());

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model = Model.getInstance();
                Location currentLocation = model.findLocation(locationTxt);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Item currItem = new Item(timestamp, currentLocation, shortDesc,
                        fullDesc, dollarValue, (Category) category_spinner.getSelectedItem());
                model.addItem(currentLocation, currItem);
                startActivity(new Intent(AddItemActivity.this, LocationDetailActivity.class));

            }
        });


    }
}
