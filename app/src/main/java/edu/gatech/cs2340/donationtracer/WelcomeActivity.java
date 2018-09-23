package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button loginBtn = (Button) findViewById(R.id.button_login);

<<<<<<< HEAD
        Button btn_login = (Button)findViewById(R.id.button_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
=======
        loginBtn.setOnClickListener(new View.OnClickListener() {
>>>>>>> ae2b28826a4d27c5ec4da58bd79c0472e5a6b7e8
            @Override
            public void onClick(View view) {
                // write your button click code here
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            }
        });

    }
}
