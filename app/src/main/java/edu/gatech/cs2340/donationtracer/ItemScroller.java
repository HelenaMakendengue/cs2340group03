package edu.gatech.cs2340.donationtracer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ItemScroller extends AppCompatActivity {

    private ArrayList<Item> itemSubList;
    private String locationName;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_scroller);

        getIncomingIntent();
        Model model = Model.getInstance();
        itemSubList = model.locationDB.get(model.findLocation(locationName));

        System.out.println("Location: " + locationName);

        for (Item i: itemSubList) {
            System.out.println(i);
        }

        //Item.getItemList().add(new Item(null, MainActivity.getDb().get(1), "Shoe", "A singular shoe", 1.00, Category.Clothing));


        recyclerView = findViewById(R.id.itemRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemRecyclerAdapter(itemSubList);
        recyclerView.setAdapter(adapter);

    }

    private void getIncomingIntent() {
        locationName = getIntent().getStringExtra("location_name");
    }

    public ArrayList<Item> getItemSubList() {
        return itemSubList;
    }
}
