package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
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
        setContentView(R.layout.activity_add_item_new);

        Button back = (Button) findViewById(R.id.button_cancel);
        Button submit = (Button) findViewById(R.id.button_add);
        EditText location = (EditText) findViewById(R.id.editText_location);
        EditText title = (EditText) findViewById(R.id.editText_title);
        EditText description = (EditText) findViewById(R.id.editText_description);
        EditText value = (EditText) findViewById(R.id.editText_value);
        EditText comment = (EditText) findViewById(R.id.text4);
        Spinner category_spinner = (Spinner) findViewById(R.id.spinner_category);


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationTxt = location.getText().toString().trim();
                String shortDesc = title.getText().toString().trim();
                String fullDesc = description.getText().toString().trim();
                Double dollarValue = Double.parseDouble(value.getText().toString());
                Model model = Model.getInstance();
                Location currentLocation = model.findLocation(locationTxt);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Item newItem = new Item(timestamp, currentLocation, shortDesc,
                        fullDesc, dollarValue, (Category) category_spinner.getSelectedItem());
                model.addItem(currentLocation, newItem);
                startActivity(new Intent(AddItemActivity.this, LocationDetailActivity.class));

            }
        });


    }
}
