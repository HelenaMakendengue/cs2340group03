package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ItemScroller extends AppCompatActivity {

    public ArrayList<Item> itemSubList;
    private String locationName;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public DatabaseReference databaseDonations;
    public ItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_scroller);
        itemSubList = new ArrayList<>();
        Button toSearch = findViewById(R.id.button_toSearch);

        getIncomingIntent();
        //Model model = Model.getInstance();
        //itemSubList = model.locationDB.get(model.findLocation(locationName));

        databaseDonations = FirebaseDatabase.getInstance().getReference("donations");

        Query query = databaseDonations.child(locationName);

        query.addValueEventListener(new ValueEventListener() {

            //public ArrayList<Item> itemSubList;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    // Update my client activity list with tbe one new item received from firebase.
                    itemSubList.add(d.getValue(Item.class));
                }

                adapter = new ItemRecyclerAdapter(itemSubList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });

        //Initially display a list with no items.
        recyclerView = findViewById(R.id.itemRecyclerView);
        layoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemRecyclerAdapter(itemSubList);
        recyclerView.setAdapter(adapter);

        toSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemScroller.this, SearchActivity.class));
            }
        });
    }

    private void getIncomingIntent() {
        locationName = getIntent().getStringExtra("location_name");
    }

    public ArrayList<Item> getItemSubList() {
        return itemSubList;
    }
}
