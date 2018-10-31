package edu.gatech.cs2340.donationtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        String timeStamp = getIntent().getStringExtra("item_timeStamp");
        String fullDesc = getIntent().getStringExtra("item_fullDesc");
        String category = getIntent().getStringExtra("item_category");

        setWidget(timeStamp, fullDesc, category);
    }

    private void setWidget(String timeStamp, String fullDesc, String category) {

        TextView item_timeStamp = findViewById(R.id.item_timeStamp);
        item_timeStamp.setText(timeStamp);

        TextView item_fullDesc = findViewById(R.id.item_fullDesc);
        item_fullDesc.setText(fullDesc);

        TextView item_category = findViewById(R.id.item_category);
        item_category.setText(category);
    }
}
