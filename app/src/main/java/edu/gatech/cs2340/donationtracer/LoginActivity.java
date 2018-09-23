package edu.gatech.cs2340.donationtracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText userName = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);

        String user = userName.toString().trim();
        String pass = password.toString().trim();

    }
}
