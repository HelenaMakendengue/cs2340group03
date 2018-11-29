package edu.gatech.cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/**
 * The welcome activity initiates the welcome screen.
 * Links to login or registration activity.
 */
public class WelcomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button loginBtn = findViewById(R.id.button_login);
        Button registerBtn = findViewById(R.id.button_register);
        Button guestBtn = findViewById(R.id.button_guest);
        Button googleBtn = findViewById(R.id.button_google);

        mAuth = FirebaseAuth.getInstance();


        loginBtn.setOnClickListener(view -> {
            // write your button click code here
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        });

        registerBtn.setOnClickListener(view -> {
            // write your button click code here
            startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
        });

        guestBtn.setOnClickListener(view -> {
            // write your button click code here
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        });

        //googleBtn.setOnClickListener(view -> {
        //    startActivity(new Intent(WelcomeActivity.this, ??????));
        //        });
    }


}
