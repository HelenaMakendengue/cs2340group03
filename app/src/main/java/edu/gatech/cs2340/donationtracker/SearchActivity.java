package edu.gatech.cs2340.donationtracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Search activity displays the search screen for search bar, search function, and the result.
*/
public class SearchActivity extends AppCompatActivity {

    private List<Item> searched;
    private ArrayList<Item> master;
    private ArrayList<String> locationNames;

    private RecyclerView recyclerView;
    private ItemRecyclerAdapter adapter;
    private Search searcher;
    private EditText searchBar;
    private Button searchButton;
    private Spinner categories;
    private Spinner locations;
    private RadioButton textOption;
    private RadioButton spinnerOption;
    private CheckBox locationActive;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialize();


        Iterable<Location> buffer = new ArrayList<>(MainActivity.getDb().values());

        for (Location loc: buffer) {
            locationNames.add(loc.getName());
        }

        DatabaseReference databaseDonations = FirebaseDatabase.getInstance()
                .getReference("donations");

        for (String loc : locationNames) {
            Query query = databaseDonations.child(loc);

            query.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot d : dataSnapshot.getChildren()) {
                        // Update my client activity list with tbe one new item
                        // received from firebase.
                        master.add(d.getValue(Item.class));
                    }

                    adapter = new ItemRecyclerAdapter(master);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Failed to read value
                    Log.w("Failed to read value.", error.toException());
                }
            });
        }


        //set up spinners
        ArrayAdapter<Category> spinnerAdapter = new ArrayAdapter(this,android.R.layout
                .simple_spinner_item, Category.values());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories.setAdapter(spinnerAdapter);

        ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter(this,android.R.layout
                .simple_spinner_item, locationNames);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locations.setAdapter(spinnerAdapter2);

        //Set up searcher
        searcher = new Search(master);


        //set up recycler view
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //search button clicked
        searchButton.setOnClickListener(v -> searchPress());


    }

    private void initialize() {
        searchBar = findViewById(R.id.search_bar);
        searchButton = findViewById(R.id.search_button);
        categories = findViewById(R.id.category_search);
        locations = findViewById(R.id.location_spinner);
        textOption = findViewById(R.id.text_option);
        spinnerOption = findViewById(R.id.spinner_option);
        locationActive = findViewById(R.id.location_check);

        searched = new ArrayList<>();
        master = new ArrayList<>();
        locationNames = new ArrayList<>();
    }

    private void searchPress() {
        @Nullable String searchLocation;
        searched.clear();

        if (locationActive.isChecked()) {
            searchLocation = (String) locations.getSelectedItem();
        } else {
            searchLocation = null;
        }

        if (textOption.isChecked()) {
            searched = searcher.searchByName(searchBar.getText().toString().toLowerCase()
                    , searchLocation);
        } else if (spinnerOption.isChecked()) {
            searched = searcher.searchByCategory((Category) categories.getSelectedItem()
                    , searchLocation);
        }

        if (searched.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No Items Matched",
                    Toast.LENGTH_LONG).show();
            adapter = new ItemRecyclerAdapter(searched);
            recyclerView.setAdapter(adapter);
        } else {
            //finish recyclerView
            adapter = new ItemRecyclerAdapter(searched);
            recyclerView.setAdapter(adapter);
        }
    }

}
