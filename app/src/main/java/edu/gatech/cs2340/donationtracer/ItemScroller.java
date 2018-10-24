package edu.gatech.cs2340.donationtracer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ItemScroller extends AppCompatActivity {

    private ArrayList<Item> itemSubList = new ArrayList<>();
    private String locationName;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ItemRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_scroller);

        getIncomingIntent();

        Item.getItemList().add(new Item(null, MainActivity.getDb().get(1), "Shoe", "A singular shoe", 1.00, Category.Clothing));

        /**for (Item i: Item.getItemList()) {
            if (i.getLocation().getName().equals(locationName)) {
                itemSubList.add(i);
            }
        }*/

        recyclerView = findViewById(R.id.itemRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemRecyclerAdapter(Item.getItemList());
        recyclerView.setAdapter(adapter);

    }

    private void getIncomingIntent() {
        locationName = getIntent().getStringExtra("location_name");
    }

    public ArrayList<Item> getItemSubList() {
        return Item.getItemList();
    }

}
