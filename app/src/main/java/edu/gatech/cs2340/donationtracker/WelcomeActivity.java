package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

/**
 * The welcome activity initiates the welcome screen.
 * Links to login or registration activity.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button loginBtn = findViewById(R.id.button_login);
        Button registerBtn = findViewById(R.id.button_register);

        loginBtn.setOnClickListener(view -> {
            // write your button click code here
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        });

        registerBtn.setOnClickListener(view -> {
            // write your button click code here
            startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
        });

    }
}
