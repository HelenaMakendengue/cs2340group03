package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Item Scroller displays the items of a selected location
 * by accessing the database
 */
public class ItemScroller extends AppCompatActivity {

    private ArrayList<Item> itemSubList;
    private String locationName;
    private RecyclerView recyclerView;
    private ItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_scroller);
        itemSubList = new ArrayList<>();
        Button toSearch = findViewById(R.id.button_toSearch);

        getIncomingIntent();
        Model model = Model.getInstance();
        itemSubList = model.getLocationDB().get(model.findLocation(locationName));

        DatabaseReference databaseDonations = FirebaseDatabase.getInstance()
                .getReference("donations");

        Query query = databaseDonations.child(locationName);

        query.addValueEventListener(new ValueEventListener() {

            //public ArrayList<Item> itemSubList;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    // Update my client activity list with tbe one new item received from firebase.
                    itemSubList.add(d.getValue(Item.class));
                }

                adapter = new ItemRecyclerAdapter(itemSubList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });

        //Initially display a list with no items.
        recyclerView = findViewById(R.id.itemRecyclerView);
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemRecyclerAdapter(itemSubList);
        recyclerView.setAdapter(adapter);

        toSearch.setOnClickListener(v ->
                startActivity(new Intent(ItemScroller.this, SearchActivity.class)));
    }

    private void getIncomingIntent() {
        locationName = getIntent().getStringExtra("location_name");
    }

// --Commented out by Inspection START (11/8/18, 5:18 PM):
    public ArrayList<Item> getItemSubList() {
        return itemSubList;
    }
// --Commented out by Inspection STOP (11/8/18, 5:18 PM)
}
