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
        String locName = getIntent().getStringExtra("item_locname");
        String shortDesc = getIntent().getStringExtra("item_shortDesc");
        String fullDesc = getIntent().getStringExtra("item_fullDesc");
        String category = getIntent().getStringExtra("item_category");
        String dollarVal = getIntent().getStringExtra("item_dollarValue");

        setWidget(timeStamp, locName, shortDesc, fullDesc, category, dollarVal);
    }

    private void setWidget(String timeStamp, String locName, String shortDesc, String fullDesc,
                                                            String category, String dollarVal) {

        TextView item_timeStamp = findViewById(R.id.item_timeStamp);
        item_timeStamp.setText(timeStamp);

        TextView item_fullDesc = findViewById(R.id.item_fullDesc);
        item_fullDesc.setText(fullDesc);

        TextView item_category = findViewById(R.id.item_category);
        item_category.setText(category);

        TextView item_shortDesc = findViewById(R.id.item_shortDesc);
        item_shortDesc.setText(shortDesc);

        TextView item_dollarValue = findViewById(R.id.item_dollarValue);
        item_dollarValue.setText(dollarVal);

        TextView item_locName = findViewById(R.id.item_locname);
        item_locName.setText(locName);
    }
}
