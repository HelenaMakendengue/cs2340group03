package edu.gatech.cs2340.donationtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ArrayList<Item> searched;
    private ArrayList<Item> master;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText searchBar = findViewById(R.id.search_bar);
        Button searchButton = findViewById(R.id.search_button);
        Spinner categories = findViewById(R.id.category_search);
        RadioButton textOption = findViewById(R.id.text_option);
        RadioButton spinnerOption = findViewById(R.id.spinner_option);
        searched = new ArrayList<>();
        master = new ArrayList<>();

        master.add(new Item(null, null, "shoe", "big shoe", 65.0, Category.Clothing));


        //set up spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Category.values());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories.setAdapter(spinnerAdapter);

        //set up recycler view
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //search button clicked
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searched.clear();

                if (textOption.isChecked()) {
                    String term = searchBar.getText().toString().toLowerCase();

                    for (Item item: master) {
                        if (item.getShortDesc().toLowerCase().contains(term)) {
                            searched.add(item);
                        }
                    }
                } else if (spinnerOption.isChecked()) {
                    for (Item item: master) {
                        if (item.getCategory().equals(categories.getSelectedItem())) {
                            searched.add(item);
                        }
                    }
                }


                if (searched.size() == 0) {
                    Toast.makeText(getApplicationContext(), "No Items Matched", Toast.LENGTH_LONG).show();
                    adapter = new ItemRecyclerAdapter(searched);
                    recyclerView.setAdapter(adapter);
                } else {
                    //finish recyclerView
                    adapter = new ItemRecyclerAdapter(searched);
                    recyclerView.setAdapter(adapter);
                }
            }
        });


    }

}
